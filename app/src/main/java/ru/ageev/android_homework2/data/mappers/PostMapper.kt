package ru.ageev.android_homework2.data.mappers


import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.model.ApiPost
import javax.inject.Inject

class PostMapper @Inject constructor() {
    fun toPost(apiModel: ApiPost) = Post(
        images = apiModel.images,
        id = apiModel.id,
        text = apiModel.text,
        likes = apiModel.likes,
        //dataCreated = apiModel.dataCreated.toString(),
    )
}