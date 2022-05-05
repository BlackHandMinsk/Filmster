package com.example.filmster.data.remote.pojo

import com.squareup.moshi.Json



data class FilmResponse(
    @Json(name = "results") val results: List<FilmPojo> = emptyList()
)