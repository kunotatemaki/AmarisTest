package com.rukiasoft.doggether.splash.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rukiasoft.amaristest.accountlist.ui.mainviews.MainActivity


class SplashActivity : AppCompatActivity() {

    internal val REQUEST_CODE_ANIMATION: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launchMainScreen()
    }

    private fun launchMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}