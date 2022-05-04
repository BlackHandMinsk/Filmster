package com.example.filmster.di

import android.content.Context
import androidx.room.Room
import com.example.filmster.data.db.FilmDatabase
import com.example.filmster.data.db.dao.FilmDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val NAME_FILE_DB = "films"

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMoviesDao(database: FilmDatabase): FilmDao {
        return database.filmsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): FilmDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            FilmDatabase::class.java,
            NAME_FILE_DB
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}