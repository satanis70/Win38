package com.example.win38.model

import androidx.annotation.Keep

@Keep
data class QuizModel(
    val questions: List<Question>
)