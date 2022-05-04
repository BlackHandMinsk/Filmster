package com.example.filmster.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.filmster.data.db.converters.Converters
import com.example.filmster.data.db.dao.FilmDao
import com.example.filmster.data.db.entity.FilmEntity

@Database(
    entities = [FilmEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmsDao(): FilmDao
}