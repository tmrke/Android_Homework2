package ru.ageev.nanopost.ui.search_fragment


import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.nanopost.R
import ru.ageev.nanopost.data.model.ProfileCompact
import ru.ageev.nanopost.databinding.ViewCardProfileCompactBinding


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
