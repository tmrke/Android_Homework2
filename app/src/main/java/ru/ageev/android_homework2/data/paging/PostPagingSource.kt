package ru.ageev.android_homework2.data.paging



import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.ageev.android_homework2.data.remote.NanopostApiService
import ru.ageev.android_homework2.data.remote.model.ApiPost
import java.lang.Exception

class PostPagingSource
    (private val apiService: NanopostApiService) :
    PagingSource<String, ApiPost>() {
    override fun getRefreshKey(state: PagingState<String, ApiPost>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ApiPost> {
        return try {
            val response = apiService.getProfilePosts(
                profileId = "evo",
                count = params.loadSize,
                offset = null
            )

            LoadResult.Page(
                response.items,
                nextKey = response.offset,
                prevKey = null,
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}