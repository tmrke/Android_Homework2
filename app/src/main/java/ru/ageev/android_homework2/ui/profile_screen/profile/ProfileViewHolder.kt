package ru.ageev.android_homework2.ui.profile_screen.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding

class ProfileViewHolder(
    private val binding: ViewProfileCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Profile) {
        with(binding) {
           imageViewUserProfileImage.load(item.avatarSmall ?: R.drawable.profile)
           textViewUserStatus.text = item.bio
            textViewUserName.text = item.displayName ?: item.username
            textViewImagesCount.text = item.imagesCount.toString()
            textViewPostsCount.text = item.postsCount.toString()
            textViewSubscribersCount.text = item.subscribersCount.toString()
        }
    }
}