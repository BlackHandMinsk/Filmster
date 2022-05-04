package com.example.filmster.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class Link(
  val suggested_link_text: String = "",
  val type: String = "",
  val url: String = ""
):Parcelable