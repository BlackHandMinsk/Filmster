package com.example.filmster.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_db") val idDb: Int = 0,
    val id: Int,
    val byline: String,
    val critics_pick: Int,
    val date_updated: String,
    val display_title: String,
    val headline: String,
    val link: String,
    val mpaa_rating: String,
    val multimedia: String,
    val opening_date: String,
    val publication_date: String,
    val summary_short: String,
    @ColumnInfo(name = "prev_key") var prevKey: Int?,
    @ColumnInfo(name = "next_key") var nextKey: Int?
)