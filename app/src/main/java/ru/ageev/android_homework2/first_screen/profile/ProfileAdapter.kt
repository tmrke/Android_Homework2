package ru.ageev.android_homework2.first_screen.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding
import ru.ageev.android_homework2.first_screen.post.PostData

val diffUtilCallback = object : DiffUtil.ItemCallback<ProfileData>() {
    override fun areItemsTheSame(oldItem: ProfileData, newItem: ProfileData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProfileData, newItem: ProfileData): Boolean {
        return oldItem == newItem
    }
}

class ProfileAdapter : ListAdapter<ProfileData, ProfileViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding =
            ViewProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}