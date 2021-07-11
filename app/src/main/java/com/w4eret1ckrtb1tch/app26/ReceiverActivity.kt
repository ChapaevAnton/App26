package com.w4eret1ckrtb1tch.app26

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.w4eret1ckrtb1tch.app26.data.Employee

class ReceiverActivity : AppCompatActivity() {

    lateinit var surName: TextView
    lateinit var name: TextView
    lateinit var fullName: TextView
    lateinit var toolBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        //val bundle = intent.extras?.getBundle(MainActivity.BUNDLE)
        val bundle = intent.getBundleExtra(MainActivity.BUNDLE)
        val employee: Employee? = bundle?.getParcelable(MainActivity.EMPLOYEE)

        surName = findViewById(R.id.surname)
        name = findViewById(R.id.name)
        fullName = findViewById(R.id.full_name)
        toolBar = findViewById(R.id.toolbar_activity2)

        employee?.let {
            surName.text = employee.surName
            name.text = employee.name
            fullName.text = employee.fullName
        }

        //добавляем панель в активити и кнопку назад
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }


    override fun onBackPressed() {
        showAlertDialog()
    }


    private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder
            .setTitle("Назад...")
            .setMessage("Вы хотите перейти назад?")
            .setPositiveButton("да") { _, _ ->
                val bundle = Bundle()
                bundle.putParcelable(
                    MainActivity.EMPLOYEE,
                    Employee(
                        surName.text.toString(),
                        name.text.toString(),
                        fullName.text.toString()
                    )
                )

                val intent = Intent().apply {
                    putExtra(MainActivity.RESULT_RECEIVER_ACTIVITY, bundle)
                }
                setResult(RESULT_OK, intent)
                finish()
            }
            .setNegativeButton("нет") { dialog, _ -> dialog.cancel() }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()

    }


}