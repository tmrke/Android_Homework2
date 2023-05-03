package ru.ageev.android_homework2.presentation.profile_screen.posts

import android.content.Context
import android.media.Image
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewPostCardBinding
import java.util.Objects

class PostsViewHolder(
    private val binding: ViewPostCardBinding,
    private val context: Context,
    private val onClick: () -> Unit

) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Post) {
        with(binding) {
            textViewPostText.text = item.text
            textViewDate.text = item.dataCreated.toString()
            textViewProfileName.text = item.owner.username
            imageButtonFavorite.text = item.likesCount.toString()
//        binding.imageViewMedia.load(item.images)
//        TODO сделайть лайк active / inactive

            viewPostCard.setOnClickListener {
                onClick()
            }
        }
    }
}