package com.example.ppr_vote.menu

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.ppr_vote.BaseActivity
import com.example.ppr_vote.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : BaseActivity() {

    private val CLASS_TAG = "MenuActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)
        setSupportActionBar(bottom_app_bar)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomMenuFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }

        return true
    }
}