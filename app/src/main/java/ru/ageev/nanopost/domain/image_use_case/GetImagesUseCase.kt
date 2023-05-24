package ru.ageev.nanopost.domain.image_use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.Image
import ru.ageev.nanopost.data.repository.ImageRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val imagesRepository: ImageRepository
) {
    suspend fun execute(profileId: String): Flow<PagingData<Image>> {
        return imagesRepository.getAllImages(profileId)
    }
}