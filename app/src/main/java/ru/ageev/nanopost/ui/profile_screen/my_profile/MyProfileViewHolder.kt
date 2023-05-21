package ru.ageev.nanopost.ui.profile_screen.my_profile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.nanopost.R
import ru.ageev.nanopost.data.model.Profile
import ru.ageev.nanopost.databinding.ViewMyProfileCardBinding

class MyProfileViewHolder(
    private val binding: ViewMyProfileCardBinding,
    private val onEditClick: (String) -> Unit,
    private val onSubscribeClick: (String) -> Unit,
    private val onUnsubscribeClick: (String) -> Unit,
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

                buttonEdit.setOnClickListener {
                    onEditClick(profile.id)
                }
            } else {
                buttonSubscribe.visibility = View.VISIBLE
                buttonEdit.visibility = View.GONE

                if (profile.subscribed) {
                    buttonSubscribe.setText(R.string.unsubscribe)

                    buttonSubscribe.setOnClickListener {
                        onUnsubscribeClick(profile.id)
                    }
                } else {
                    buttonSubscribe.setText(R.string.subscribe)

                    buttonSubscribe.setOnClickListener {
                        onSubscribeClick(profile.id)
                    }
                }
            }
        }
    }
}