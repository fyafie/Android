package com.example.projectdia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        var movieId = intent.getIntExtra("movieId",0)
        Log.d("Success", movieId.toString())
    }
}