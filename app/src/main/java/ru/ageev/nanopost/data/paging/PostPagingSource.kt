package ru.ageev.nanopost.data.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.ageev.nanopost.data.remote.NanopostApiService
import ru.ageev.nanopost.data.remote.model.ApiPost
import java.lang.Exception
import javax.inject.Inject

class PostPagingSource @Inject constructor(
    private val apiService: NanopostApiService,
    private val profileId: String,
) :
    PagingSource<String, ApiPost>() {
    override fun getRefreshKey(state: PagingState<String, ApiPost>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ApiPost> {
        return try {
            val response = apiService.getProfilePosts(
                profileId = profileId,
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