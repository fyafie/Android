package com.example.projectdia.ultils

import com.example.projectdia.model.MovieResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apikey: String = MovieRepository.API_KEY,
        @Query("page") page: Int
    ): Call<MovieResponseModel>

    @GET("movie/{movieId}")
    fun getDetailMovie(
        @Path("movieId") movieId: Int,
        @Query("api_key") apikey: String = MovieRepository.API_KEY
    ): Call<MovieResponseModel>
}