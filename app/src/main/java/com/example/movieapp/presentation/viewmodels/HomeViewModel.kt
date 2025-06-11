package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.movieapp.domain.usecase.UseCases
import javax.inject.Inject

class HomeViewModel @Inject constructor(useCases: UseCases) : ViewModel() {

    val getAllHeroes = useCases.getAllHeroesUseCases()
}