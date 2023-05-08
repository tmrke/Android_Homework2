package ru.ageev.android_homework2.data.mappers

import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.remote.model.ApiProfile
import javax.inject.Inject

class ProfileMapper @Inject constructor() {
    fun toProfile(apiModel: ApiProfile) = Profile(
        id = apiModel.id,
        username = apiModel.username,
        //bio = apiModel.bio,
//        avatarId = apiModel.avatarId,
//        avatarSmall = apiModel.avatarSmall,
//        avatarLarge = apiModel.avatarLarge,
//        displayName = apiModel.displayName,
        subscribed =  apiModel.subscribed,
        imagesCount = apiModel.imagesCount,
        postsCount = apiModel.postsCount,
        subscribersCount = apiModel.subscribersCount,
    )
}