package com.example.win38

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import coil.load

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val iv = findViewById<ImageView>(R.id.iv_background_main_screen)
        iv.load("http://49.12.202.175/win38/back.jpg")
        val buttonStart = findViewById<Button>(R.id.button_start_quiz)
        buttonStart.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
            finish()
        }
    }
}