package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class Rideconfirmbook : AppCompatActivity() {

    var btnConfirm: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rideconfirmbook)
        btnConfirm = findViewById(R.id.btnConfirm)
        btnConfirm?.setOnClickListener {

            val intent = Intent(this, Changepickupspot::class.java)
            startActivity(intent)
        }
    }
}