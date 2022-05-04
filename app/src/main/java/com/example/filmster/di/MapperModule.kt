package com.example.filmster.di

import com.example.filmster.data.mappers.MapFilmPojoToFilmInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideMapCharacterPojoToCharacterInfo(): MapFilmPojoToFilmInfo {
        return MapFilmPojoToFilmInfo()
    }

}