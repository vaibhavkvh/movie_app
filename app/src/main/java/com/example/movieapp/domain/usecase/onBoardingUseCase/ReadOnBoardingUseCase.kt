package com.example.movieapp.domain.usecase.onBoardingUseCase

import com.example.movieapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    suspend operator fun invoke() : Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}