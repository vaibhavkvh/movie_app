package com.example.movieapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success : Boolean ,
    val message : String?=null,
    val prePage : Int? = null,
    val nextPage : Int? = null,
    val heroes : List<Hero> = emptyList()
)
