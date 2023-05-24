package ru.ageev.nanopost.domain.image_use_case

import ru.ageev.nanopost.data.model.Image
import ru.ageev.nanopost.data.repository.ImageRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend fun execute(imageId: String): Image {
        return repository.getImage(imageId)
    }
}