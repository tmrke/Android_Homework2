package ru.ageev.android_homework2.data.remote.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.android_homework2.data.model.Image

interface ImageRepository {
    suspend fun getAllImages(profileId: String): Flow<PagingData<Image>>
}