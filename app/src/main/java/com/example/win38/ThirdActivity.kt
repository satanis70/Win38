package com.example.win38

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.win38.model.QuizModel
import com.example.win38.services.NflApi
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class ThirdActivity : AppCompatActivity() {
    private val nflList = ArrayList<QuizModel>()
    private var currentPos = 0
    private var rightAnswers = 0
    private lateinit var buttonNextQuiz: Button
    private val ID = "714b9f14-381d-4fc4-a93c-28d480557381"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ID)
        buttonNextQuiz = findViewById(R.id.button_next)
        val iv = findViewById<ImageView>(R.id.iv_background_third_screen)
        iv.load("http://49.12.202.175/win38/back.jpg")
        getData()
        buttonNextQuiz.setOnClickListener {
            currentPos++
            if (currentPos==nflList[0].questions.size){
                val intent = Intent(this, FourActivity::class.java)
                intent.putExtra("rightAnswers", rightAnswers)
                intent.putExtra("size", nflList[0].questions.size)
                startActivity(intent)
                finish()
            } else {
                showOnScreen()
            }
        }
    }

    fun getData(){
        nflList.clear()
        CoroutineScope(Dispatchers.IO).launch {
            val nflApi = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/win38/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NflApi::class.java)
            val callApi = nflApi.getAll().awaitResponse()
            if (callApi.isSuccessful){
                nflList.add(callApi.body()!!)
            }
            launch(Dispatchers.Main) {
                showOnScreen()
            }
        }
    }

    private fun showOnScreen(){
        val buttonA1 = findViewById<Button>(R.id.button_a1)
        val buttonA2 = findViewById<Button>(R.id.button_a2)
        val buttonA3 = findViewById<Button>(R.id.button_a3)
        val buttonA4 = findViewById<Button>(R.id.button_a4)
        val textViewQuestion = findViewById<TextView>(R.id.textView_question)
        buttonNextQuiz.isEnabled = false
        buttonA1.isEnabled = true
        buttonA2.isEnabled = true
        buttonA3.isEnabled = true
        buttonA4.isEnabled = true
        buttonA1.setBackgroundColor(resources.getColor(R.color.color_button))
        buttonA2.setBackgroundColor(resources.getColor(R.color.color_button))
        buttonA3.setBackgroundColor(resources.getColor(R.color.color_button))
        buttonA4.setBackgroundColor(resources.getColor(R.color.color_button))
        textViewQuestion.text = nflList[0].questions[currentPos].question
        buttonA1.text = nflList[0].questions[currentPos].answer1.name
        buttonA2.text = nflList[0].questions[currentPos].answer2.name
        buttonA3.text = nflList[0].questions[currentPos].answer3.name
        buttonA4.text = nflList[0].questions[currentPos].answer4.name
        buttonA1.setOnClickListener {
            if (nflList[0].questions[currentPos].answer1.trueorfalse=="true"){
                buttonA1.setBackgroundColor(resources.getColor(R.color.text_green))
                rightAnswers+=1
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            } else {
                buttonA1.setBackgroundColor(resources.getColor(R.color.text_red))
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            }
        }
        buttonA2.setOnClickListener {
            if (nflList[0].questions[currentPos].answer2.trueorfalse=="true"){
                buttonA2.setBackgroundColor(resources.getColor(R.color.text_green))
                rightAnswers+=1
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            } else {
                buttonA2.setBackgroundColor(resources.getColor(R.color.text_red))
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            }
        }
        buttonA3.setOnClickListener {
            if (nflList[0].questions[currentPos].answer3.trueorfalse=="true"){
                buttonA3.setBackgroundColor(resources.getColor(R.color.text_green))
                rightAnswers+=1
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            } else {
                buttonA3.setBackgroundColor(resources.getColor(R.color.text_red))
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            }
        }
        buttonA4.setOnClickListener {
            if (nflList[0].questions[currentPos].answer4.trueorfalse=="true"){
                buttonA4.setBackgroundColor(resources.getColor(R.color.text_green))
                rightAnswers+=1
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            } else {
                buttonA4.setBackgroundColor(resources.getColor(R.color.text_red))
                buttonA1.isEnabled = false
                buttonA2.isEnabled = false
                buttonA3.isEnabled = false
                buttonA4.isEnabled = false
                buttonNextQuiz.isEnabled = true
            }
        }
    }
}