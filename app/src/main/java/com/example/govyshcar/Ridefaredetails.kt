package com.example.govyshcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class Ridefaredetails : AppCompatActivity() {

    var btnreturnHome: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ridefaredetails)
        btnreturnHome = findViewById(R.id.btnreturnHome)
        btnreturnHome?.setOnClickListener {

            val intent = Intent(this, Drivercoming::class.java)
            startActivity(intent)
        }
    }
}