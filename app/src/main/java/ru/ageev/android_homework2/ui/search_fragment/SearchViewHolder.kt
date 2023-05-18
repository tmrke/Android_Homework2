package ru.ageev.android_homework2.ui.search_fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.FragmentSearchBinding
import ru.ageev.android_homework2.databinding.ViewMyProfileCardBinding


class SearchViewHolder (private val binding: ViewMyProfileCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: Profile) {
        with(binding) {
            imageViewUserProfileImage.load(profile.avatarSmall ?: R.drawable.profile)
            textViewUserStatus.text = profile.bio
            textViewUserName.text = profile.displayName ?: profile.username
            textViewImagesCount.text = profile.imagesCount.toString()
            textViewPostsCount.text = profile.postsCount.toString()
            textViewSubscribersCount.text = profile.subscribersCount.toString()

            buttonSubscribe.visibility = View.GONE
            buttonEdit.visibility = View.GONE
        }
    }
}
