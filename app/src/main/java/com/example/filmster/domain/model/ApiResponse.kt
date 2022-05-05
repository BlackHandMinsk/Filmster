package com.example.filmster.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiResponse(
    val copyright: String = "",
    val has_more: Boolean = false,
    val num_results: Int = 0,
    val results: List<FilmInfo> = emptyList(),
    val status: String
):Parcelable