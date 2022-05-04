package com.example.filmster.di

import com.example.filmster.domain.usecases.GetRemoteListFilmsUseCase
import com.example.filmster.domain.repository.FilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetRemoteListFilmsUseCase(
        repository: FilmRepository
    ): GetRemoteListFilmsUseCase {
        return GetRemoteListFilmsUseCase(repository = repository)
    }
}