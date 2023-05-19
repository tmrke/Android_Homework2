package ru.ageev.android_homework2.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.ageev.android_homework2.data.remote.NanopostApiService
import ru.ageev.android_homework2.data.remote.model.ApiProfileCompact
import java.lang.Exception

class ProfilePagingSource(
    private val query: String,
    private val apiService: NanopostApiService,
) : PagingSource<String, ApiProfileCompact>() {
    override fun getRefreshKey(state: PagingState<String, ApiProfileCompact>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ApiProfileCompact> {
        return try {
            val response = apiService.searchProfile(
                query = query,
                count = params.loadSize,
                offset = null
            )

            LoadResult.Page(
                response.items,
                prevKey = response.offset,
                nextKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}