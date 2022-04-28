package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Forgotpassword : AppCompatActivity() {
    var btnResetPass: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        btnResetPass = findViewById(R.id.btnResetPass)
        btnResetPass?.setOnClickListener {

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}