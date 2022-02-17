package com.example.projectdia.remote

import com.example.projectdia.model.DayLimaResponse
import io.reactivex.Single

interface AppRemoteDataSource {
    fun getAllJob(): Single<DayLimaResponse>
}