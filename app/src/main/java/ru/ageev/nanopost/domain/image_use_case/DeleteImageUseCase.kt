package ru.ageev.nanopost.domain.image_use_case

import ru.ageev.nanopost.data.repository.ImageRepository
import javax.inject.Inject

class DeleteImageUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {
    suspend fun execute(imageId: String) {
        imageRepository.deleteImage(imageId)
    }
}