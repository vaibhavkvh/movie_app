package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.usecase.onBoardingUseCase.ReadOnBoardingUseCase
import com.example.movieapp.domain.usecase.onBoardingUseCase.SaveOnBoardingUseCase

data class UseCases(
    val onBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
