package com.example.movieapp.data.repository

import androidx.paging.PagingData
import com.example.movieapp.domain.model.Hero
import com.example.movieapp.domain.repository.DataStoreOperations
import com.example.movieapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor( private val remoteDataSource: RemoteDataSource, private val dataStore : DataStoreOperations){

    fun getAllHeroes(): Flow<PagingData<Hero>>{
        return remoteDataSource.getAllHeroes()
    }

    suspend fun saveOnBoardingState(isCompleted : Boolean){
        dataStore.saveOnBoardingState(isCompleted)
    }

    fun readOnBoardingState() : Flow<Boolean>{
        return  dataStore.readOnBoardingState()
    }
}