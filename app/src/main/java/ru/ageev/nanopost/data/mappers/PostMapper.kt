package ru.ageev.nanopost.data.mappers


import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.remote.model.ApiPost
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class PostMapper @Inject constructor (
    private val imagesMapper: ImagesMapper,
    private val profileCompactMapper: ProfileCompactMapper,
) {
    fun toPost(apiModel: ApiPost) = Post(

        images = apiModel.images.map { image ->
            imagesMapper.toImages(image)
        },
        id = apiModel.id,
        text = apiModel.text,
        likes = apiModel.likes,
        owner = profileCompactMapper.toProfileCompact(apiModel.owner),
        dateCreated = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
            .format(Date(apiModel.dateCreated))
    )
}