package com.tailnode.assignment

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager (context:Context){

    private val FILE_NAME = "SP_LOGIN"
    private val IS_LOGGEN_IN = "isLoggedIn"

    val pref:SharedPreferences? = context?.getSharedPreferences(FILE_NAME,0)
    val editor: SharedPreferences.Editor? = pref?.edit()

    fun setLogin(isLogin : Boolean){
        editor?.putBoolean(IS_LOGGEN_IN,isLogin)
        editor?.commit()
    }

    fun setUsername(username: String){
        editor?.putString("Username",username)
        editor?.commit()
    }

    fun isLogin(): Boolean? {
        return pref?.getBoolean(IS_LOGGEN_IN,false)
    }

    fun removeLoginData(){
        editor?.clear()
        editor?.commit()
    }
}