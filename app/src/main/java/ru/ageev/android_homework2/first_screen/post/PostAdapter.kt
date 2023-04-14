package ru.ageev.android_homework2.first_screen.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

val diffUtilCallback = object : DiffUtil.ItemCallback<PostData>() {
    override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
        return oldItem == newItem
    }
}

class PostAdapter : ListAdapter<PostData, PostViewHolder>(diffUtilCallback) {
    var onClick: () -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: ViewPostCardBinding =
            ViewPostCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val context = parent.context

        return PostViewHolder(binding, context, onClick)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind()
    }
}