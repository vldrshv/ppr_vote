package com.example.ppr_vote.login.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.ppr_vote.BaseActivity

import com.example.ppr_vote.R
import com.example.ppr_vote.login.LoginController
import com.example.ppr_vote.login.LoginPresenter
import com.example.ppr_vote.signup.view.SignupActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginController.View {

    private val CLASS_TAG = "LoginActivity"
    private val loginPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        email.afterTextChanged {
            // TODO validate email
        }
        password.afterTextChanged {
            login.isEnabled = (!getEmail().isBlank() && !getPassword().isBlank())
        }
        login.setOnClickListener { loginPresenter.onLoginClicked() }
        forgetPassword.setOnClickListener { loginPresenter.onForgetClicked() }
        signup.setOnClickListener { loginPresenter.onSignupClicked() }
    }

    override fun getEmail(): String {
        return email.text.toString()
    }

    override fun getPassword(): String {
        return password.text.toString()
    }

    override fun showError() {
        passwordTIL.error = "ERROR"
        Log.i(CLASS_TAG, "ERROR")
    }

    @SuppressLint("ShowToast")
    override fun welcomeUser() {
        Log.i(CLASS_TAG, "Welcome ${getEmail()}")
        Toast.makeText(this, "Welcome ${getEmail()}", Toast.LENGTH_LONG).show()
    }

    override fun registerUser() {
        startActivity(Intent(this, SignupActivity::class.java))
    }
}
