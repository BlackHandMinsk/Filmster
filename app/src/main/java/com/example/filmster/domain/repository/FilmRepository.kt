package com.example.filmster.domain.repository

import androidx.paging.PagingData

import com.example.filmster.model.FilmInfo
import com.example.filmster.utils.Resource
import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getListFilms(): Flow<PagingData<FilmInfo>>
    fun getFilm(id: String):Flow<Resource<FilmInfo>>
}