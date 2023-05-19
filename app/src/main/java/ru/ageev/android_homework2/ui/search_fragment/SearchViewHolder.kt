package ru.ageev.android_homework2.ui.search_fragment

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.model.ProfileCompact
import ru.ageev.android_homework2.databinding.FragmentSearchBinding
import ru.ageev.android_homework2.databinding.ViewCardProfileCompactBinding
import ru.ageev.android_homework2.databinding.ViewMyProfileCardBinding


class SearchViewHolder(private val binding: ViewCardProfileCompactBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: ProfileCompact) {
        with(binding) {
            imageViewUserProfileImage.load(profile.avatarUrl ?: R.drawable.profile)
            textViewUserName.text = profile.displayName ?: profile.username
        }
    }
}
