package com.example.filmster.data.db.converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromList(value: List<String>?): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toList(value: String): List<String>? {
        if (value == "") return emptyList()
        return Json.decodeFromString(value)
    }
}