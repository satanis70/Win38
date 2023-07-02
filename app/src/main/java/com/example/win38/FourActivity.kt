package com.example.win38

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.load

class FourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)
        val iv = findViewById<ImageView>(R.id.iv_background_four_screen)
        iv.load("http://49.12.202.175/win38/back.jpg")
        val tvRes = findViewById<TextView>(R.id.textView_result)
        val rightAnswers = intent.getIntExtra("rightAnswers", 0)
        val size = intent.getIntExtra("size", 0)
        val result = resources.getText(R.string.result)
        tvRes.text = "$result$rightAnswers/$size"
        val buttonStartAgain = findViewById<Button>(R.id.button_start_again)
        buttonStartAgain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}