package com.example.filmster.domain

import com.example.filmster.domain.repository.FilmRepository

class GetRemoteListFilmsUseCase(private val repository: FilmRepository) {
    operator fun invoke() = repository.getListFilms()
}