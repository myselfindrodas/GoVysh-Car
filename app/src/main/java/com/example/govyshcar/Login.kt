package com.example.govyshcar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class Login : AppCompatActivity() {

    var btnSignup: AppCompatTextView? = null
    var btnLogin: AppCompatButton? = null
    var btnForgotpass: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnSignup = findViewById(R.id.btnSignup)
        btnLogin = findViewById(R.id.btnLogin)
        btnForgotpass = findViewById(R.id.btnForgotpass)
        btnForgotpass?.setOnClickListener {

            val intent = Intent(this, Forgotpassword::class.java)
            startActivity(intent)
        }

        btnSignup?.setOnClickListener {

            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        btnLogin?.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}