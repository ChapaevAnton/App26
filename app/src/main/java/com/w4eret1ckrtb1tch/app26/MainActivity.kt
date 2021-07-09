package com.w4eret1ckrtb1tch.app26

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.w4eret1ckrtb1tch.app26.data.Employee

class MainActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE = "BUNDLE"
        const val EMPLOYEE = "EMPLOYEE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surName: EditText = findViewById(R.id.surname_edit)
        val name: EditText = findViewById(R.id.name_edit)
        val fullName: EditText = findViewById(R.id.full_name_edit)
        val onSendButton: Button = findViewById(R.id.on_button_send)

        onSendButton.setOnClickListener {
            val employee = Employee(
                surName.text.toString(),
                name.text.toString(),
                fullName.text.toString()
            )

            val bundle = Bundle()
            bundle.putParcelable(EMPLOYEE, employee)

            val intent = Intent(this, ReceiverActivity::class.java)
            intent.putExtra(BUNDLE, bundle)
            startActivity(intent)

        }

    }
}