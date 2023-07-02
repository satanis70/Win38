package com.example.win38

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import coil.load

class FirstScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)
        val iv = findViewById<ImageView>(R.id.iv_background_first_screen)
        iv.load("http://49.12.202.175/win38/back.jpg")
        Handler().postDelayed({
            startActivity(Intent(this@FirstScreenActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }
}