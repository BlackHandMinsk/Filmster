package com.example.filmster.model

import com.example.filmster.data.remote.pojo.FilmPojo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name="copyright") val copyright: String,
    @Json(name="has_more") val has_more: Boolean,
    @Json(name="num_results")val num_results: Int,
    @Json(name="results")val results: List<FilmPojo>,
    @Json(name="status")val status: String
)