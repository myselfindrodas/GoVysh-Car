package com.example.govyshcar

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Secure
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.govyshcar.Allurl.Allurl
import com.example.govyshcar.internet.CheckConnectivity
import org.json.JSONException
import org.json.JSONObject


class Login : AppCompatActivity() {

    var btnSignup: AppCompatTextView? = null
    var btnLogin: AppCompatButton? = null
    var btnForgotpass: TextView? = null
    var etEmail: EditText? = null
    var etPassword: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnSignup = findViewById(R.id.btnSignup)
        btnLogin = findViewById(R.id.btnLogin)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
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

//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)

            checkblank()
        }
    }


    private fun checkblank(){

        if (etEmail?.text.toString().length==0){
            Toast.makeText(this, "Please enter a Valid Email", Toast.LENGTH_SHORT).show()
        }else if (etPassword?.text.toString().length==0){
            Toast.makeText(this, "Please enter a Password", Toast.LENGTH_SHORT).show()
        }else{

            login()
        }
    }


    private fun login(){

        val deviceId = Secure.getString(contentResolver, Secure.ANDROID_ID)
        val version = Build.VERSION.SDK_INT
        val deviceName = Build.MODEL // returns model name

        if (CheckConnectivity.getInstance(applicationContext).isOnline()) {
            showProgressDialog()
            val params = JSONObject()
            try {
                params.put("userId", etEmail?.text.toString())
                params.put("password", etPassword?.text.toString())
                params.put("userType", "ADMIN USER")
                params.put("deviceToken", "abc")
                params.put("loginThough", "Mobile")
                params.put("deviceId", deviceId)
                params.put("deviceOsVersion", version)
                params.put("deviceModel", deviceName)
                params.put("socialMediaName", "")
                params.put("latitude", "22.55")
                params.put("logitude", "44.09")


            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val jsonRequest = JsonObjectRequest(
                Request.Method.POST, Allurl.loginUrl, params,
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
                            Log.d(ContentValues.TAG, "unsuccessfull - " + "Error")
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
            Toast.makeText(
                applicationContext,
                "Ooops! Internet Connection Error",
                Toast.LENGTH_SHORT
            ).show()
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