package com.example.filmster.di

import android.content.Context
import com.example.filmster.data.mappers.MapFilmPojoToFilmInfo
import com.example.filmster.data.remote.FilmApiService
import com.example.filmster.data.repository.FilmRepositoryImpl
import com.example.filmster.domain.repository.FilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(
        apiService: FilmApiService,
        mapFilmPojoToFilmInfo: MapFilmPojoToFilmInfo,
        @ApplicationContext context: Context
    ): FilmRepository {
        return FilmRepositoryImpl(
            service = apiService,
            mapFilmPojoToFilmInfo = mapFilmPojoToFilmInfo,
            context=context
        )
    }
}