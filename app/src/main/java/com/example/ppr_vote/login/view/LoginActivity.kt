package com.example.ppr_vote.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText

import com.example.ppr_vote.R
import com.example.ppr_vote.login.LoginController
import com.example.ppr_vote.login.LoginPresenter
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginController.View {

    private val CLASS_TAG = "LoginActivity"
    private val loginPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        email.afterTextChanged {
            // TODO validate email
        }
        password.afterTextChanged {
            login.isEnabled = (!email.text!!.isBlank() && !password.text!!.isBlank())
        }
        login.setOnClickListener { loginPresenter.onLoginClicked() }

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

    override fun welcomeUser() {
        Log.i(CLASS_TAG, "Welcome $email")
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}
