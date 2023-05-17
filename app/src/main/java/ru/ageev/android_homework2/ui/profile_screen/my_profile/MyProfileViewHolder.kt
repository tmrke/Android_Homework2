package ru.ageev.android_homework2.ui.profile_screen.my_profile

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewMyProfileCardBinding

class MyProfileViewHolder(
    private val binding: ViewMyProfileCardBinding,
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


            buttonEdit.setOnClickListener {
//                if (profile.subscribed) {
//                    buttonSubscribe.text = "unsubscribe"
//                    buttonSubscribe.setBackgroundColor(R.color.md_theme_light_onSurfaceVariant.hashCode())
//                } else {
//                    buttonSubscribe.text = "subscribe"
//                    buttonSubscribe.setBackgroundColor(R.color.md_theme_dark_surfaceVariant.hashCode())
//                }

                onClick(profile.id)
            }
        }
    }
}