package com.example.ppr_vote.login

import android.util.Log
import android.view.View
import com.example.ppr_vote.login.model.UserDAO

class LoginPresenter : LoginController.Presenter {

    private val CLASS_TAG = "LoginPresenter"

    private var _mView: LoginController.View? = null
    private var _mUserDAO: UserDAO? = null

    constructor(mView: LoginController.View) {
        _mView = mView
        _mUserDAO = UserDAO()
    }

    override fun onLoginClicked() {
        if (validatePassword())
            _mView?.welcomeUser()
        else
            _mView?.showError()
    }

    override fun onForgetClicked() {
        Log.i(CLASS_TAG, "forget password for ${_mUserDAO!!.getEmail()}")
    }

    override fun onSignupClicked() {
        _mView?.registerUser()
    }

    override fun validatePassword(): Boolean {
        val password = _mUserDAO?.getPassword()
        val viewPassword = _mView?.getPassword()
        Log.i(CLASS_TAG, "password = $password, viewPassword = $viewPassword")

        return password != null && password == viewPassword
    }

    override fun onDestroy() {
        Log.i(CLASS_TAG, "onDestroy()")
    }
}