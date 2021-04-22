package com.roadtocode.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myData", MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val mobile = etMobile.text.toString()

            editor.apply {
                putString("name", name)
                putString("mobile", mobile)
                apply() //commit()
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name", " ")
            val mobile = sharedPref.getString("mobile", " ")

            etName.setText(name)
            etMobile.setText(mobile)
        }
    }
}