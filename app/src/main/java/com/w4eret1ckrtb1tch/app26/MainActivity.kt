package com.w4eret1ckrtb1tch.app26

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.w4eret1ckrtb1tch.app26.data.Employee

class MainActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE = "BUNDLE"
        const val EMPLOYEE = "EMPLOYEE"
        const val REQUEST_CODE = 1001
        const val RESULT_RECEIVER_ACTIVITY = "RESULT_RECEIVER_ACTIVITY"
        const val ACTION_RECEIVER_ACTIVITY = "com.app26.activity.receiver"
    }

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surName: EditText = findViewById(R.id.surname_edit)
        val name: EditText = findViewById(R.id.name_edit)
        val fullName: EditText = findViewById(R.id.full_name_edit)
        val onSendButton: Button = findViewById(R.id.on_button_send)
        val onIntentButton: Button = findViewById(R.id.on_button_intent)
        textResult = findViewById(R.id.text_result)

        activityResultLauncher =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result?.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    val bundle = data?.getBundleExtra(RESULT_RECEIVER_ACTIVITY)
                    val employee: Employee? = bundle?.getParcelable(EMPLOYEE)

                    val string = "${employee?.surName} ${employee?.name} ${employee?.fullName}"
                    Log.d("TEST", "ActivityResultLauncher: $string")
                    textResult.text = string
                }
            }

        onSendButton.setOnClickListener {
            val employee = Employee(
                surName.text.toString(),
                name.text.toString(),
                fullName.text.toString()
            )

            val bundle = Bundle()
            bundle.putParcelable(EMPLOYEE, employee)

            val intentExplicit = Intent(this, ReceiverActivity::class.java).apply {
                putExtra(BUNDLE, bundle)
            }
            //Deprecated
            //startActivityForResult(intentExplicit, REQUEST_CODE)
            activityResultLauncher.launch(intentExplicit)

        }

        onIntentButton.setOnClickListener {
//            val  intentImplicit = Intent(ACTION_RECEIVER_ACTIVITY)
//            startActivity(intentImplicit)

            val sendIntentImplicit = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            }


            if (sendIntentImplicit.resolveActivity(packageManager) != null) {
                val shareIntentImplicit = Intent.createChooser(sendIntentImplicit, null)
                startActivity(shareIntentImplicit)
            } else {
                Toast.makeText(this, "Sorry, no such app", Toast.LENGTH_SHORT).show()
            }

        }

    }

//Deprecated
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        Log.d("TEST", "onActivityResult: $requestCode $resultCode $data")
//        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
//
//            val bundle = data?.getBundleExtra(RESULT_RECEIVER_ACTIVITY)
//            val employee: Employee? = bundle?.getParcelable(EMPLOYEE)
//
//            val string = "${employee?.surName} ${employee?.name} ${employee?.fullName}"
//            Log.d("TEST", "onActivityResult: $string")
//            textResult.text = string
//        }
//
//    }

}