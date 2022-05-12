package com.example.govyshcar

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.govyshcar.Allurl.Allurl
import com.example.govyshcar.internet.CheckConnectivity
import org.json.JSONException
import org.json.JSONObject

class Registration : AppCompatActivity() {

    var btnSignin: TextView? = null
    var btnRegistration: AppCompatButton? = null
    var etName: EditText? = null
    var etEmail: EditText? = null
    var etMobile: EditText? = null
    var etPassword: EditText? = null
    var cbAgreement: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnSignin = findViewById(R.id.btnSignin)
        btnRegistration = findViewById(R.id.btnRegistration)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMobile = findViewById(R.id.etMobile)
        etPassword = findViewById(R.id.etPassword)
        cbAgreement = findViewById(R.id.cbAgreement)

        btnSignin?.setOnClickListener {

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnRegistration?.setOnClickListener {
            checkblank()
        }

    }

    private fun checkblank() {

        if (etName?.text.toString().length == 0) {
            Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show()
        } else if (etEmail?.text.toString().length == 0) {
            Toast.makeText(this, "Please enter a Valid Email", Toast.LENGTH_SHORT).show()
        } else if (etMobile?.text.toString().length == 0) {
            Toast.makeText(this, "Please enter a Phone Number", Toast.LENGTH_SHORT).show()
        } else if (etPassword?.text.toString().length == 0) {
            Toast.makeText(this, "Please enter a Password", Toast.LENGTH_SHORT).show()
        } else if (cbAgreement?.isChecked == false) {
            Toast.makeText(this, "Please Check the Agreement", Toast.LENGTH_SHORT).show()
        } else {

            Registration()
            verifyOTP()

        }

    }

    private fun Registration() {

        if (CheckConnectivity.getInstance(applicationContext).isOnline()) {
            showProgressDialog()
            val params = JSONObject()
            try {
                params.put("userName", etName?.text.toString())
                params.put("password", etPassword?.text.toString())
                params.put("mobileNo", etMobile?.text.toString())
                params.put("email", etEmail?.text.toString())
                params.put("userType", "ADMIN USER")
                params.put("deviceToken", "abc")

            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val jsonRequest = JsonObjectRequest(
                Request.Method.POST, Allurl.RegistrationUrl, params,
                { response: JSONObject ->
                    Log.i("Response-->", response.toString())
                    try {
                        val result = JSONObject(response.toString())
                        val msg = result.getString("message")
                        Log.d(TAG, "msg-->$msg")
                        if (msg.equals("The User Successfully Registered")) {
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                            verifyOTP()
//                            val intent = Intent(this, OTP::class.java)
//                            startActivity(intent)
//                            val intent = Intent(this, Emailverification::class.java)
//                            intent.putExtra("email", email)
//                            startActivity(intent)

//                        JSONObject userdeatisObj = result.getJSONObject("data");
//
//
//                        id = userdeatisObj.getInt("id");
//                        status = userdeatisObj.getString("status");
//                        role = userdeatisObj.getString("role");
//                        name = userdeatisObj.getString("name");
//                        email = userdeatisObj.getString("email");
//                        email_verification_code = userdeatisObj.getString("email_verification_code");
//                        phone_no = userdeatisObj.getString("phone_no");
//                        otp_time = userdeatisObj.getInt("otp_time");
                        } else {
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    hideProgressDialog()
                }
            ) { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
                error.printStackTrace()
                //TODO: handle failure
            }
            Volley.newRequestQueue(this).add(jsonRequest)
        } else {
            Toast.makeText(
                applicationContext,
                "Ooops! Internet Connection Error",
                Toast.LENGTH_SHORT
            ).show()
        }

    }


    private fun verifyOTP(){

        if (CheckConnectivity.getInstance(applicationContext).isOnline()) {
            showProgressDialog()
            val params = JSONObject()
            try {
                params.put("userId", etEmail?.text.toString())
                params.put("purpose", "VERIFY_USER")


            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val jsonRequest = JsonObjectRequest(
                Request.Method.POST, Allurl.verifyOTP, params,
                { response: JSONObject ->
                    Log.i("Response-->", response.toString())
                    try {
                        val result = JSONObject(response.toString())
//                        val msg = result.getString("message")
//                        Log.d(ContentValues.TAG, "msg-->$msg")
//                        if (msg.equals("The User Successfully Registered")) {
//                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                            val intent = Intent(this, OTP::class.java)
//                            startActivity(intent)
//                            val intent = Intent(this, Emailverification::class.java)
//                            intent.putExtra("email", email)
//                            startActivity(intent)

//                        JSONObject userdeatisObj = result.getJSONObject("data");
//
//
//                        id = userdeatisObj.getInt("id");
//                        status = userdeatisObj.getString("status");
//                        role = userdeatisObj.getString("role");
//                        name = userdeatisObj.getString("name");
//                        email = userdeatisObj.getString("email");
//                        email_verification_code = userdeatisObj.getString("email_verification_code");
//                        phone_no = userdeatisObj.getString("phone_no");
//                        otp_time = userdeatisObj.getInt("otp_time");
                        hideProgressDialog()
//                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                        } else {
////                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    hideProgressDialog()
                }
            ) { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
                error.printStackTrace()
                //TODO: handle failure
            }
            Volley.newRequestQueue(this).add(jsonRequest)
        } else {
            Toast.makeText(applicationContext, "Ooops! Internet Connection Error", Toast.LENGTH_SHORT).show()
        }
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