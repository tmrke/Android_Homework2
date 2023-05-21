package ru.ageev.nanopost.domain.image

import ru.ageev.nanopost.data.model.Image
import ru.ageev.nanopost.data.remote.repository.ImageRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend fun execute(imageId: String): Image {
        return repository.getImage(imageId)
    }
}