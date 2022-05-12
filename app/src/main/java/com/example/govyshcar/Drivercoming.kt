package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Drivercoming : AppCompatActivity() {

    var btnCancelride: AppCompatButton? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drivercoming)
        btnCancelride = findViewById(R.id.btnCancelride)
        btnCancelride?.setOnClickListener {

            val intent = Intent(this, Ratedriver::class.java)
            startActivity(intent)
        }
    }
}