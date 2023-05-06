package ru.ageev.android_homework2.presentation.profile_screen.posts

import android.content.Context
import android.media.Image
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
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
//            textViewDate.text = item.dataCreated
//            textViewProfileName.text = item.owner.username
//            imageViewMedia.load(item.images)

            imageButtonFavorite.setIconResource(
                if (item.likes.liked) {
                    R.drawable.heart
                } else {
                    R.drawable.favorite
                }
            )


            imageButtonFavorite.text = item.likes.likesCount.toString()


            imageButtonFavorite.setOnClickListener {
                if (item.likes.liked) {
                    imageButtonFavorite.text = item.likes.likesCount.toString()
                    imageButtonFavorite.setIconResource(R.drawable.favorite)
                } else {
                    imageButtonFavorite.text = (item.likes.likesCount + 1).toString()
                    imageButtonFavorite.setIconResource(R.drawable.heart)
                }

                item.likes.liked = !item.likes.liked
            }

            imageButtonFavorite.text = item.likes.likesCount.toString()

            viewPostCard.setOnClickListener {
                onClick()
            }
        }
    }
}