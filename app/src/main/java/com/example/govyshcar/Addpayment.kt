package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton

class Addpayment : AppCompatActivity() {

    var btnWallet: LinearLayout? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addpayment)
        btnWallet = findViewById(R.id.btnWallet)
        btnWallet?.setOnClickListener {

            val intent = Intent(this, Cancelreason::class.java)
            startActivity(intent)
        }
    }
}