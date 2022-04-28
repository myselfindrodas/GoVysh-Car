package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class Registration : AppCompatActivity() {

    var btnSignin: TextView? = null
    var btnRegistration: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnSignin = findViewById(R.id.btnSignin)
        btnRegistration = findViewById(R.id.btnRegistration)
        btnSignin?.setOnClickListener {

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnRegistration?.setOnClickListener {

            val intent = Intent(this, OTP::class.java)
            startActivity(intent)
        }

    }
}