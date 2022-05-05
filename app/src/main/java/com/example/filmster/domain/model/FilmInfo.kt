package com.example.filmster.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmInfo(
    val byline: String = "",
    val critics_pick: Int = 0,
    val date_updated: String = "",
    val display_title: String = "",
    val headline: String = "",
    val link: String = "",
    val mpaa_rating: String = "",
    val multimedia: String = "",
    val opening_date: String = "",
    val publication_date: String = "",
    val summary_short: String = ""
):Parcelable