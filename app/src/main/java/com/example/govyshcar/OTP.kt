package com.example.govyshcar

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.govyshcar.Allurl.Allurl
import com.example.govyshcar.internet.CheckConnectivity
import org.json.JSONException
import org.json.JSONObject

class OTP : AppCompatActivity() {

    var btnLogin: AppCompatButton? = null
    var etOtp: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        btnLogin = findViewById(R.id.btnLogin)
        etOtp = findViewById(R.id.etOtp)
        etOtp?.setOnClickListener {

            checkblank()
        }
        btnLogin?.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun checkblank(){
        if (etOtp?.text.toString().length==0){

            Toast.makeText(this, "Please enter a Valid OTP", Toast.LENGTH_SHORT).show()

        }else{

            OTP()
        }

    }

    private fun OTP(){


    }


    var mProgressDialog: ProgressDialog? = null

    fun showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setMessage(getString(R.string.loading))
            mProgressDialog!!.isIndeterminate = true
        }
        mProgressDialog!!.show()
    }

    fun hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
        }
    }
}