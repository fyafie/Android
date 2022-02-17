package com.example.projectdia.remote

import com.example.projectdia.model.DayLimaResponse
import com.example.projectdia.service.AppService
import io.reactivex.Single
import javax.inject.Inject

class AppRemoteDataSourceImpl @Inject constructor(private val service:AppService):AppRemoteDataSource {
    override fun getAllJob(): Single<DayLimaResponse> {
        return service.getAllJob()
    }
}