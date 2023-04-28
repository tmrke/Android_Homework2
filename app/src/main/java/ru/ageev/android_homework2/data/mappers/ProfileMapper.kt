package ru.ageev.android_homework2.data.mappers

import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.remote.ApiProfile
import javax.inject.Inject

class ProfileMapper @Inject constructor() {
    fun toProfile(apiModel: ApiProfile) = Profile(
        id = apiModel.id,
        username = apiModel.username,
        bio = apiModel.bio,
        avatarId = apiModel.avatarId,
        avatarSmall = apiModel.avatarSmall,
        avatarLarge = apiModel.avatarLarge,
        subscribed =  apiModel.subscribed,
        displayName = apiModel.displayName,
        imagesCount = apiModel.imagesCount,
        postsCount = apiModel.postsCount,
        subscribersCount = apiModel.subscribersCount
    )
}