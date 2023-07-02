package com.example.win38.services

import com.example.win38.model.QuizModel
import retrofit2.Call
import retrofit2.http.GET

interface NflApi {
    @GET("nflquestions.json")
    fun getAll():Call<QuizModel>
}