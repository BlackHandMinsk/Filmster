package com.example.filmster.data.remote.pojo

import com.squareup.moshi.Json


data class FilmPojo(
    @Json(name = "byline") val byline: String,
    @Json(name = "critics_pick") val critics_pick: Int,
    @Json(name = "date_updated") val date_updated: String,
    @Json(name = "display_title") val display_title: String,
    @Json(name = "headline") val headline: String,
    @Json(name = "link") val link: LinkPojo,
    @Json(name = "mpaa_rating") val mpaa_rating: String,
    @Json(name = "multimedia") val multimedia: MultimediaPojo,
    @Json(name = "publication_date") val publication_date: String,
    @Json(name = "summary_short") val summary_short: String
)