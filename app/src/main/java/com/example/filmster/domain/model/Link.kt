package com.example.filmster.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Link(
  val suggested_link_text: String = "",
  val type: String = "",
  val url: String = ""
):Parcelable