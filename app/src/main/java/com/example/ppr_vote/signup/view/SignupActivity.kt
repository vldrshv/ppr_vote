package com.example.ppr_vote.signup.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ppr_vote.BaseActivity
import com.example.ppr_vote.R
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)
        email.afterTextChanged {
//             TODO validate email
        }
        password.afterTextChanged {
//
        }
//        login.setOnClickListener { loginPresenter.onLoginClicked() }
//        forgetPassword.setOnClickListener { loginPresenter.onForgetClicked() }

    }
}