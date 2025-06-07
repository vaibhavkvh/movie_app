package com.example.movieapp.domain.usecase.onBoardingUseCase

import com.example.movieapp.data.repository.Repository

class SaveOnBoardingUseCase ( private val repository: Repository) {

    suspend operator fun invoke(isCompleted : Boolean){
        repository.saveOnBoardingState(isCompleted)
    }
}