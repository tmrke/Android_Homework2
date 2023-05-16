package ru.ageev.android_homework2.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import ru.ageev.android_homework2.data.mappers.PostMapper
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.paging.FeedPagingSource
import ru.ageev.android_homework2.data.paging.PostPagingSource
import ru.ageev.android_homework2.data.remote.NanopostApiService
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: NanopostApiService,
    private val postMapper: PostMapper
) :
    PostRepository {
    override suspend fun getPost(postId: String): Post {
        return postMapper.toPost(apiService.getPost(postId))
    }

    override suspend fun deletePost(postId: String) {
        apiService.deletePost(postId)
    }

    override suspend fun getFeed(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(30, enablePlaceholders = false),
            pagingSourceFactory = { FeedPagingSource(apiService) }
        ).flow.map { pagingData ->
            pagingData.map { apiPost ->
                postMapper.toPost(apiPost)
            }
        }
    }

    override suspend fun createPost(text: String?, list: List<ByteArray>?): Post {
        var image0: MultipartBody.Part? = null

        list?.getOrNull(0)?.let {
            image0 = MultipartBody.Part.createFormData(
                "image1",
                "image1.jpg",
                it.toRequestBody("image/*".toMediaType())
            )
        }

        var image1: MultipartBody.Part? = null

        list?.getOrNull(1)?.let {
            image1 = MultipartBody.Part.createFormData(
                "image2",
                "image2.jpg",
                it.toRequestBody("image/*".toMediaType())
            )
        }

        var image2: MultipartBody.Part? = null

        list?.getOrNull(2)?.let {
            image2 = MultipartBody.Part.createFormData(
                "image3",
                "image3.jpg",
                it.toRequestBody("image/*".toMediaType())
            )
        }

        var image3: MultipartBody.Part? = null

        list?.getOrNull(3)?.let {
            image3 = MultipartBody.Part.createFormData(
                "image4",
                "image4.jpg",
                it.toRequestBody("image/*".toMediaType())
            )
        }

        return postMapper.toPost(
            apiService.createPost(
                text?.toRequestBody(),
                image0,
                image1,
                image2,
                image3
            )
        )
    }
}