package ru.ageev.android_homework2.ui.profile_screen.my_profile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewMyProfileCardBinding

class MyProfileViewHolder(
    private val binding: ViewMyProfileCardBinding,
    private val onEditClick: (String) -> Unit,
    private val onProfileClick: (String) -> Unit,
    private val isMyProfile: Boolean
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: Profile) {
        with(binding) {
            imageViewUserProfileImage.load(profile.avatarSmall ?: R.drawable.profile)
            textViewUserStatus.text = profile.bio
            textViewUserName.text = profile.displayName ?: profile.username
            textViewImagesCount.text = profile.imagesCount.toString()
            textViewPostsCount.text = profile.postsCount.toString()
            textViewSubscribersCount.text = profile.subscribersCount.toString()

            if (isMyProfile) {
                buttonSubscribe.visibility = View.GONE
                buttonEdit.visibility = View.VISIBLE
            } else {
                buttonSubscribe.visibility = View.VISIBLE
                buttonEdit.visibility = View.GONE

                if (profile.subscribed) {
                    buttonSubscribe.setText(R.string.unsubscribe)
                } else {
                    buttonSubscribe.setText(R.string.subscribe)
                }
            }

            buttonSubscribe.setOnClickListener {
                buttonSubscribe.setText(R.string.unsubscribe)
                onProfileClick(profile.id)
            }

            buttonEdit.setOnClickListener {
                onEditClick(profile.id)
            }
        }
    }
}