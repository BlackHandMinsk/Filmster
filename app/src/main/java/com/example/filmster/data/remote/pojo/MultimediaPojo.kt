package com.example.filmster.data.remote.pojo

import com.squareup.moshi.Json

data class MultimediaPojo (
    @Json(name="height")val height: Int,
    @Json(name="src")val src: String ,
    @Json(name="type")val type: String,
    @Json(name="width")val width: Int
        )