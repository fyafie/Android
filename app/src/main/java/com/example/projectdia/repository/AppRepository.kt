package com.example.projectdia.repository

import com.example.projectdia.model.DayLimaResponse
import io.reactivex.Single

interface AppRepository {
    fun getAllJob(): Single<DayLimaResponse>
}