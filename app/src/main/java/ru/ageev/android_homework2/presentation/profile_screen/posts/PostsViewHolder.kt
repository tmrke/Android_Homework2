package ru.ageev.android_homework2.presentation.profile_screen.posts

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.ViewPostCardBinding
import ru.ageev.android_homework2.presentation.post_screen.PostViewModel

class PostsViewHolder(
    private val binding: ViewPostCardBinding,
    private val postViewModel: PostViewModel,
    private val onClick: (String) -> Unit,

    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        with(binding) {
            textViewPostText.text = post.text
//            textViewDate.text = item.dataCreated
//            textViewProfileName.text = item.owner.username
//            imageViewMedia.load(item.images?.get(0)?.images?.get(0))

            imageButtonFavorite.setIconResource(
                if (post.likes.liked) {
                    R.drawable.heart
                } else {
                    R.drawable.favorite
                }
            )

            imageButtonFavorite.text = post.likes.likesCount.toString()

            imageButtonFavorite.setOnClickListener {
                if (post.likes.liked) {
                    imageButtonFavorite.text = post.likes.likesCount.toString()
                    imageButtonFavorite.setIconResource(R.drawable.favorite)
                } else {
                    imageButtonFavorite.text = (post.likes.likesCount + 1).toString()
                    imageButtonFavorite.setIconResource(R.drawable.heart)
                }

                post.likes.liked = !post.likes.liked
            }

            textViewPostText.setOnClickListener {
                postViewModel.getPost(post.id)
                onClick(post.id)
            }

            imageViewMedia.setOnClickListener {
                postViewModel.getPost(post.id)
                onClick(post.id)
            }
        }
    }
}