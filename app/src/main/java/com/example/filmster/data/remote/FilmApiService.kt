package com.example.filmster.data.remote

import com.example.filmster.data.remote.pojo.FilmPojo
import com.example.filmster.data.remote.pojo.FilmResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val PARAMS_PAGE = "offset"

interface FilmApiService {

    @GET("/svc/movies/v2/reviews/all.json?api-key=WSklheugM7pdn5F42nAb9nnuJhj6cTIY")
    suspend fun getListOfFilms(
        @retrofit2.http.Query(PARAMS_PAGE) page: Int
    ): Response<FilmResponse?>

    @GET("/svc/movies/v2/reviews/search.json?query={name}?api-key=WSklheugM7pdn5F42nAb9nnuJhj6cTIY")
    suspend fun getFilm(
        @Path("name") id: String
    ):Response<FilmPojo?>
}