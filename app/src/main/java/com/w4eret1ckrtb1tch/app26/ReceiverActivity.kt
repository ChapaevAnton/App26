package com.w4eret1ckrtb1tch.app26

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.w4eret1ckrtb1tch.app26.data.Employee

class ReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        //val bundle = intent.extras?.getBundle(MainActivity.BUNDLE)
        val bundle = intent.getBundleExtra(MainActivity.BUNDLE)
        val employee: Employee? = bundle?.getParcelable(MainActivity.EMPLOYEE)

        val surName: TextView = findViewById(R.id.surname)
        val name: TextView = findViewById(R.id.name)
        val fullName: TextView = findViewById(R.id.full_name)

        employee?.let {
            surName.text = employee.surName
            name.text = employee.name
            fullName.text = employee.fullName
        }
    }
}