package ru.ageev.nanopost.data.mappers

import ru.ageev.nanopost.data.model.Profile
import ru.ageev.nanopost.data.remote.model.ApiProfile
import javax.inject.Inject

class ProfileMapper @Inject constructor(
    private val imagesMapper: ImagesMapper,
) {
    fun toProfile(apiModel: ApiProfile) = Profile(
        id = apiModel.id,
        username = apiModel.username,
        displayName = apiModel.displayName ?: apiModel.username,
        bio = apiModel.bio,
        avatarId = apiModel.avatarId,
        avatarSmall = apiModel.avatarSmall,
        avatarLarge = apiModel.avatarLarge,
        subscribed = apiModel.subscribed,
        imagesCount = apiModel.imagesCount,
        postsCount = apiModel.postsCount,
        subscribersCount = apiModel.subscribersCount,
        images = apiModel.images.map { image ->
            imagesMapper.toImages(image)
        }
    )
}