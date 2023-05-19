package ru.ageev.android_homework2.ui.profile_screen.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

val diffUtilCallback = object : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}

class PostsAdapter:
    PagingDataAdapter<Post, PostsViewHolder>(diffUtilCallback) {

    var onPostClick: (String) -> Unit = {}
    var onProfileClick: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding: ViewPostCardBinding =
            ViewPostCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostsViewHolder(binding, onPostClick, onProfileClick)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        getItem(position)?.let { post ->
            holder.bind(post)

            holder.itemView.setOnClickListener {
                onPostClick(post.id)
            }
        }
    }
}