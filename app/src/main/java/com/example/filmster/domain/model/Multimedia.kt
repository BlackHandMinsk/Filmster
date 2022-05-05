package com.example.filmster.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Multimedia(
     val height: Int = 0,
     val src: String = "",
    val type: String = "",
    val width: Int = 0
):Parcelable