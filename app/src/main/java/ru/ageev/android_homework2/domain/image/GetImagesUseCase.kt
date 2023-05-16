package ru.ageev.android_homework2.domain.image

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.remote.repository.ImageRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val imagesRepository: ImageRepository
) {
    suspend fun execute(profileId: String): Flow<PagingData<Image>> {
        return imagesRepository.getAllImages(profileId)
    }
}