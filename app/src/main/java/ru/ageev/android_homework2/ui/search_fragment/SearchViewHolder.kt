package ru.ageev.android_homework2.ui.search_fragment


import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.ProfileCompact
import ru.ageev.android_homework2.databinding.ViewCardProfileCompactBinding


class SearchViewHolder(
    private val binding: ViewCardProfileCompactBinding,
    private var onPostClick: (String) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: ProfileCompact) {
        with(binding) {
            imageViewUserProfileImage.load(profile.avatarUrl ?: R.drawable.profile)
            textViewUserName.text = profile.displayName ?: profile.username

            root.setOnClickListener {
                onPostClick(profile.id)
            }
        }
    }
}
