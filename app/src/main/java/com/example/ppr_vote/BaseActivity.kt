package com.example.ppr_vote

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

open class BaseActivity : AppCompatActivity() {

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

    fun showHint(hintText: String) {
        showHint(hintText, currentFocus!!.id)
    }

    fun showHint(hintText: String, id: Int) {
        val focus = findViewById<View>(id)
        val snackbar = Snackbar.make(focus, hintText, Snackbar.LENGTH_INDEFINITE)
        val snackbarView = snackbar.view
        val snackBarTextView = snackbarView.findViewById<TextView>(R.id.snackbar_text)
        snackBarTextView.isSingleLine = false
        snackbar.setAction("Понятно") { snackbar.dismiss() }
        snackbar.show()
    }
}