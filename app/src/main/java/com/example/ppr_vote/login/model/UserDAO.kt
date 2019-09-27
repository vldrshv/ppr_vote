package com.example.ppr_vote.login.model

import android.util.Log
import com.example.ppr_vote.login.LoginController

class UserDAO : LoginController.Model {
    private val CLASS_TAG = "UserDAO"

    private val user = User(1, "a@a.a", "1")

    override fun getEmail(): String {
        Log.i(CLASS_TAG, "email = ${user.email}")
        return user.email
    }

    override fun getPassword(): String {
        Log.i(CLASS_TAG, "password = ${user.password}")
        return user.password
    }
}