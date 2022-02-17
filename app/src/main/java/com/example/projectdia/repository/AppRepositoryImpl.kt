package com.example.projectdia.repository

import com.example.projectdia.model.DayLimaResponse
import com.example.projectdia.remote.AppRemoteDataSource
import io.reactivex.Single
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val remoteDataSource: AppRemoteDataSource):AppRepository {
    override fun getAllJob(): Single<DayLimaResponse> {
        return remoteDataSource.getAllJob()
    }

}