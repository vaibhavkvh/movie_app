package com.example.movieapp.data.remote

import com.example.movieapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/boruto/heroes")
    suspend fun getAllHeroes(@Query("page") page: Int = 1): ApiResponse

    @GET("/boruto/hero/search")
    suspend fun searchHeroes(@Query("name") name: String): ApiResponse
}