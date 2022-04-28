package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Changepickupspot : AppCompatActivity() {

    var btnConfirmride: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepickupspot)
        btnConfirmride = findViewById(R.id.btnConfirmride)
        btnConfirmride?.setOnClickListener {

            val intent = Intent(this, Bookingwaiting::class.java)
            startActivity(intent)
        }
    }
}