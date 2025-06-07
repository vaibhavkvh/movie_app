package com.example.movieapp.data.repository

import com.example.movieapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val dataStore : DataStoreOperations){

    suspend fun saveOnBoardingState(isCompleted : Boolean){
        dataStore.saveOnBoardingState(isCompleted)
    }

    fun readOnBoardingState() : Flow<Boolean>{
        return  dataStore.readOnBoardingState()
    }
}