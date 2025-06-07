package com.example.movieapp.di

import android.content.Context
import com.example.movieapp.data.repository.DataStoreOperationImpl
import com.example.movieapp.data.repository.Repository
import com.example.movieapp.domain.repository.DataStoreOperations
import com.example.movieapp.domain.usecase.UseCases
import com.example.movieapp.domain.usecase.onBoardingUseCase.ReadOnBoardingUseCase
import com.example.movieapp.domain.usecase.onBoardingUseCase.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            onBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }
}