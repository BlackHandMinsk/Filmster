package com.example.filmster.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class Multimedia(
     val height: Int = 0,
     val src: String = "",
    val type: String = "",
    val width: Int = 0
):Parcelable