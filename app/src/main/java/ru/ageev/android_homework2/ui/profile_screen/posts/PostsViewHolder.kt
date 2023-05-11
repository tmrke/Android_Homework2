package ru.ageev.android_homework2.ui.profile_screen.posts

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.ViewPostCardBinding
import ru.ageev.android_homework2.ui.post_screen.PostViewModel

class PostsViewHolder(
    private val binding: ViewPostCardBinding,
    private val postViewModel: PostViewModel,
    private val onClick: (String) -> Unit,

    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        with(binding) {

            textViewPost.text = post.text
//            textViewDate.text = item.dataCreated
//            textViewProfileName.text = item.owner.username

            //val url = post.images?.get(0)?.images?.get(0)?.url



            imageViewMedia.load("https://funik.ru/wp-content/uploads/2018/10/17478da42271207e1d86.jpg")

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

            textViewPost.setOnClickListener {
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