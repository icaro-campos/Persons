package br.itc.persons.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.itc.persons.model.Person
import br.itc.persons.network.RetroService

class PersonPagingSource(val apiService: RetroService): PagingSource<Int, Person>() {

    override fun getRefreshKey(state: PagingState<Int, Person>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> {
        return try {
            val page = params.key ?: FIRST_PAGE
            val response = apiService.getDataFromApi(page)
            return LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = page + FIRST_PAGE
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}