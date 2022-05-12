package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Addcard : AppCompatActivity() {

    var btnAddpayment:AppCompatButton?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcard)
        btnAddpayment = findViewById(R.id.btnAddpayment)
        btnAddpayment?.setOnClickListener {

            val intent = Intent(this, Ridefaredetails::class.java)
            startActivity(intent)
        }

    }
}