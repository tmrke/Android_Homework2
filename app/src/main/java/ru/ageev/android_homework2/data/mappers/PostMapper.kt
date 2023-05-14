package ru.ageev.android_homework2.data.mappers


import android.util.Log
import kotlinx.serialization.SerializationException
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.model.ApiPost
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class PostMapper @Inject constructor(
    private val imagesMapper: ImagesMapper,
    private val profileCompactMapper: ProfileCompactMapper,
) {
    fun toPost(apiModel: ApiPost) = Post(

//        images = apiModel.images?.map { image ->
//            imagesMapper.toImages(image)
//        },
        id = apiModel.id,
        text = apiModel.text,
        likes = apiModel.likes,
        owner = profileCompactMapper.toProfileCompact(apiModel.owner),
        dateCreated = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            .format(Date(apiModel.dateCreated))
    )
}