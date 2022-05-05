package com.example.filmster.data.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmster.data.remote.FilmApiService
import com.example.filmster.data.remote.pojo.FilmPojo
import retrofit2.HttpException


private const val STARTING_PAGE = 20

class SearchPagingSource(
    private val service: FilmApiService,
) : PagingSource<Int, FilmPojo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmPojo> {
        try {
            val position = params.key ?: STARTING_PAGE
            val response = service.getListOfFilms(page = position)

            return if (response.isSuccessful) {
                val searchResults = response.body()?.results ?: emptyList()
                val nextKey = if (searchResults.isEmpty()) null else position + 20
                val prevKey = if (position == STARTING_PAGE) null else position - 20
                LoadResult.Page(data = searchResults, prevKey = prevKey, nextKey = nextKey)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, FilmPojo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(20)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(20)
        }
    }
}