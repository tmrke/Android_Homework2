package ru.ageev.android_homework2.ui.profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewProfileCardBinding

class ProfileViewHolder(
    private val binding: ViewProfileCardBinding,
    private val onClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: Profile) {
        with(binding) {
            imageViewUserProfileImage.load(profile.avatarSmall ?: R.drawable.profile)
            textViewUserStatus.text = profile.bio
            textViewUserName.text = profile.displayName ?: profile.username
            textViewImagesCount.text = profile.imagesCount.toString()
            textViewPostsCount.text = profile.postsCount.toString()
            textViewSubscribersCount.text = profile.subscribersCount.toString()

            buttonSubscribe.setOnClickListener {
                onClick(profile.id)

            }
        }
    }
}