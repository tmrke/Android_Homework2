package ru.ageev.nanopost.data.remote.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.Image

interface ImageRepository {
    suspend fun getAllImages(profileId: String): Flow<PagingData<Image>>

    suspend fun getImage(imageId: String): Image

    suspend fun deleteImage(imageId: String)
}