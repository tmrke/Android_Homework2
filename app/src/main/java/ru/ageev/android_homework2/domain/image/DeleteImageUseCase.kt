package ru.ageev.android_homework2.domain.image

import ru.ageev.android_homework2.data.remote.repository.ImageRepository
import javax.inject.Inject

class DeleteImageUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {
    suspend fun execute(imageId: String) {
        imageRepository.deleteImage(imageId)
    }
}