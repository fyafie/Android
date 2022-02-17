package com.example.projectdia.service

import com.example.projectdia.model.DayLimaResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface AppService {
    @GET("api/v1/jobs")
    fun getAllJob(): Single<DayLimaResponse>

    @POST("http://18.142.83.48:9092/api/v1/user/login")
    fun postLogin()
}