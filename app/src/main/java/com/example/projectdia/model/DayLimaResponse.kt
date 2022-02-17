package com.example.projectdia.model

data class DayLimaResponse(
    val code: Int,
    val `data`: List<Data>,
    val status: String
)