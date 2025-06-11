package com.example.movieapp.domain.usecase.heroes_usecases

import androidx.paging.PagingData
import com.example.movieapp.data.repository.Repository
import com.example.movieapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCases (private val repository: Repository) {

    operator fun invoke() : Flow<PagingData<Hero>> {
        return  repository.getAllHeroes()
    }
}