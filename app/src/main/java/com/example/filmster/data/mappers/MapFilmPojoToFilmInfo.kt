package com.example.filmster.data.mappers

import com.example.filmster.data.remote.pojo.FilmPojo
import com.example.filmster.model.FilmInfo
import com.example.filmster.utils.Mapper

class MapFilmPojoToFilmInfo : Mapper<FilmPojo, FilmInfo> {
    override fun map(from: FilmPojo): FilmInfo {
        return FilmInfo(
            byline = from.byline,
            critics_pick = from.critics_pick,
            date_updated = from.date_updated,
            display_title = from.display_title,
            headline = from.headline,
            link = from.link.url,
            mpaa_rating = from.mpaa_rating,
            multimedia = from.multimedia.src,
            opening_date = from.opening_date,
            publication_date = from.publication_date,
            summary_short=from.summary_short
        )
    }
}