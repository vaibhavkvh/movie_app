package com.example.movieapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movieapp.data.local.MovieDatabase
import com.example.movieapp.data.pagingsoruce.HeroRemoteMediator
import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.domain.model.Hero
import com.example.movieapp.domain.repository.RemoteDataSource
import com.example.movieapp.util.Constants.ITEM_PER_PAGE
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(val movieApi: MovieApi, val database: MovieDatabase) : RemoteDataSource {

    private val heroDao = database.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }

        return Pager(
            config = PagingConfig(pageSize = ITEM_PER_PAGE),
            remoteMediator = HeroRemoteMediator(movieApi = movieApi, database),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}