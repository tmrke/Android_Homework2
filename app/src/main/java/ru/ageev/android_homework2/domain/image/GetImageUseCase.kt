package ru.ageev.android_homework2.domain.image

import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.remote.repository.ImageRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend fun execute(imageId: String): Image {
        return repository.getImage(imageId)
    }
}