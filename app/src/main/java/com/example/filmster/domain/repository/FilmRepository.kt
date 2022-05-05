package com.example.filmster.domain.repository

import androidx.paging.PagingData

import com.example.filmster.domain.model.FilmInfo
import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getListFilms(): Flow<PagingData<FilmInfo>>
}