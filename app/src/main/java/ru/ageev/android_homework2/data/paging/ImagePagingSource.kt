package ru.ageev.android_homework2.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.ageev.android_homework2.data.remote.NanopostApiService
import ru.ageev.android_homework2.data.remote.model.ApiImage
import java.lang.Exception

class ImagePagingSource(
    private val apiService: NanopostApiService,
    private val profileId: String,
) : PagingSource<String, ApiImage>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ApiImage> {
        return try {
            val response = apiService.getAllImages(
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

    override fun getRefreshKey(state: PagingState<String, ApiImage>): String? {
        return null
    }
}