package com.example.filmster.data.repository

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.filmster.data.mappers.MapFilmPojoToFilmInfo
import com.example.filmster.data.paging.SearchPagingSource
import com.example.filmster.data.remote.FilmApiService
import com.example.filmster.domain.repository.FilmRepository
import com.example.filmster.domain.model.FilmInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private const val STARTING_PAGE_SIZE = 60

class FilmRepositoryImpl(
    private val service: FilmApiService,
    private val mapFilmPojoToFilmInfo: MapFilmPojoToFilmInfo,
    private val context: Context
) : FilmRepository {

    override fun getListFilms(): Flow<PagingData<FilmInfo>> {
        return Pager(
            config = PagingConfig(
                pageSize = STARTING_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchPagingSource(
                    service = service
                )
            }
        ).flow.map { pagingData ->
            pagingData.map {
                mapFilmPojoToFilmInfo.map(it)
            }
        }
    }
}