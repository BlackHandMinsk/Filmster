package com.example.filmster.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.filmster.data.db.entity.FilmEntity

@Dao
interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: List<FilmEntity>)

    @Query("SELECT * from films WHERE id = :key")
    suspend fun getFilmById(key: Int): FilmEntity?

    @Query("DELETE FROM films")
    suspend fun clear()

    @Query("SELECT * FROM films ")
    fun getAllFilms(): PagingSource<Int, FilmEntity>

}