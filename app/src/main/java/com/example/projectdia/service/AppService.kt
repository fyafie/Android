package com.example.projectdia.service

import com.example.projectdia.model.DayLimaResponse
import io.reactivex.Single
import retrofit2.http.GET

interface AppService {
    @GET("api/v1/jobs")
    fun getAllJob(): Single<DayLimaResponse>
}