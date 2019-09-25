package com.example.ppr_vote.login

interface LoginController {
    interface View {
        fun getEmail(): String
        fun getPassword(): String
        fun showError()
        fun welcomeUser()
    }

    interface Presenter {
        fun onLoginClicked()
        fun validatePassword(): Boolean
        fun onDestroy()
    }

    interface Model {
        fun getEmail(): String
        fun getPassword(): String
    }
}