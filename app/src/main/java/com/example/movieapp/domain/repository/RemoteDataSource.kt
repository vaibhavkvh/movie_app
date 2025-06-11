package com.example.movieapp.domain.repository

import androidx.paging.PagingData
import com.example.movieapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllHeroes() : Flow<PagingData<Hero>>

    fun searchHeroes() : Flow<PagingData<Hero>>
}