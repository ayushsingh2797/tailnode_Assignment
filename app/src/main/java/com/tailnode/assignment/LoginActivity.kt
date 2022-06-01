package com.tailnode.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager
    private lateinit var etUsername : EditText
    private lateinit var etMobile : EditText
    private lateinit var username :String
    private lateinit var mobile :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        checkLogin()
        setListeners()
    }

    private fun init(){
        preferenceManager = PreferenceManager(this)
        etMobile= findViewById(R.id.etMobile)
        etUsername = findViewById(R.id.etName)
    }

    private fun checkLogin(){
        if(preferenceManager.isLogin()!!){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun setListeners(){
        var loginButton : Button? = findViewById(R.id.loginButton)

        loginButton?.setOnClickListener{
        v:View -> clickLogin(v)
        }
    }

    private fun clickLogin(view: View) {
        username =etUsername.text.toString().trim()
        mobile = etMobile.text.toString().trim()

        if(username.isEmpty() || username =="") {
            etUsername.error = "Username should not be empty"
            etUsername.requestFocus()
        }
        else if (mobile.isEmpty() || mobile =="") {
            etMobile.error = "Mobile should not be empty"
            etMobile.requestFocus()
        }
        else{
            preferenceManager.setLogin(true)
            val intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}