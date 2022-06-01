package com.tailnode.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        checkLogin()
    }
    private fun init(){
        preferenceManager = PreferenceManager(this)
    }

    private fun checkLogin(){
        if(preferenceManager.isLogin() == false){
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}