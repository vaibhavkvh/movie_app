package com.example.movieapp.data.pagingsoruce

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.movieapp.data.local.MovieDatabase
import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.domain.model.Hero
import com.example.movieapp.domain.model.HeroRemoteKeys
import jakarta.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : RemoteMediator<Int, Hero>() {


    private val heroDao = movieDatabase.heroDao()
    private val heroRemoteKeyDao = movieDatabase.heroRemoteKeyDao()


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Hero>
    ): MediatorResult {
        return try {

            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }

            }

            val response = movieApi.getAllHeroes(page = page)
            if (response.heroes.isNotEmpty()) {
                //this withTransaction allow to execute multiple database operations sequentially one by one
                movieDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        heroDao.deleteAllHeroes()
                        heroRemoteKeyDao.deleteAllRemoteKeys()
                    }

                    val nextPage = response.nextPage
                    val prevPage = response.prePage

                    val keys = response.heroes.map { hero ->
                        HeroRemoteKeys(id = hero.id, nextPage = nextPage, prevPage = prevPage)
                    }

                    heroRemoteKeyDao.addAllRemoteKey(keys)
                    heroDao.adHeroes(response.heroes)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (ex: Exception) {
            MediatorResult.Error(ex)
        }
    }


    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                heroRemoteKeyDao.getRemoteKeys(id)
            }
        }
    }


    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { hero ->
            heroRemoteKeyDao.getRemoteKeys(hero.id)
        }
    }


    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { hero ->
            heroRemoteKeyDao.getRemoteKeys(hero.id)
        }
    }
}