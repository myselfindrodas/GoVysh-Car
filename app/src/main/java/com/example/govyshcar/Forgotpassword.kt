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

class Forgotpassword : AppCompatActivity() {
    var btnResetPass: AppCompatButton? = null
    var etEmail: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        btnResetPass = findViewById(R.id.btnResetPass)
        etEmail = findViewById(R.id.etEmail)
        btnResetPass?.setOnClickListener {

//            val intent = Intent(this, Resetpassword::class.java)
//            startActivity(intent)
            checkblank()
        }

    }

    private fun checkblank(){

        if (etEmail?.text.toString().length==0){
            Toast.makeText(this, "Please enter a Valid Email", Toast.LENGTH_SHORT).show()
        }else{

            forgotpassword()
        }
    }

    private fun forgotpassword(){

        if (CheckConnectivity.getInstance(applicationContext).isOnline()) {
            showProgressDialog()
            val params = JSONObject()
            try {
                params.put("userId", etEmail?.text.toString())
                params.put("purpose", "FORGOT_PASSWORD")


            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val jsonRequest = JsonObjectRequest(
                Request.Method.POST, Allurl.ForgotPassword, params,
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