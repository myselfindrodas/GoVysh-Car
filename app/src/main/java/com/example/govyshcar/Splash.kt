package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class Splash : AppCompatActivity() {

    var btnNext : AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        btnNext = findViewById(R.id.btnNext)
        btnNext?.setOnClickListener {

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}