package ru.ageev.android_homework2.data.mappers

import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.model.ImageSize
import ru.ageev.android_homework2.data.remote.model.ApiImage
import javax.inject.Inject

class ImagesMapper @Inject constructor() {
    fun toImages(apiImages: ApiImage) = Image(
        id = apiImages.id,
        sizes = apiImages.sizes.map { imageSize ->
            ImageSize(
                url = imageSize.url,
                width = imageSize.width,
                height = imageSize.height
            )
        },
        owner = apiImages.owner,
        dateCreated = apiImages.dateCreated
    )
}