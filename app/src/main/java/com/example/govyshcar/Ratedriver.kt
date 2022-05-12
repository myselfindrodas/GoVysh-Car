package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Ratedriver : AppCompatActivity() {

    var btnSubmit: AppCompatButton?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratedriver)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit?.setOnClickListener {
            val intent = Intent(this, Mybooking::class.java)
            startActivity(intent)
        }
    }
}