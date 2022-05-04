package com.example.filmster.data.remote.pojo

import com.squareup.moshi.Json

data class LinkPojo (
    @Json(name="suggested_link_text")   val suggested_link_text: String,
    @Json(name="type") val type: String,
    @Json(name="url") val url: String
)