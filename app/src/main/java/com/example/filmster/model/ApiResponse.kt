package com.example.filmster.model

import android.os.Parcelable
import com.example.filmster.data.remote.pojo.FilmPojo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiResponse(
    val copyright: String = "",
    val has_more: Boolean = false,
    val num_results: Int = 0,
    val results: List<FilmInfo> = emptyList(),
    val status: String
):Parcelable