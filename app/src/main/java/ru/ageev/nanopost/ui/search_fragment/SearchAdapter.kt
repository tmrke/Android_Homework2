package ru.ageev.nanopost.ui.search_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.ageev.nanopost.data.model.ProfileCompact
import ru.ageev.nanopost.databinding.ViewCardProfileCompactBinding

val diffUtilCallback = object : DiffUtil.ItemCallback<ProfileCompact>() {
    override fun areItemsTheSame(oldItem: ProfileCompact, newItem: ProfileCompact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProfileCompact, newItem: ProfileCompact): Boolean {
        return oldItem == newItem
    }
}

class SearchAdapter :
    PagingDataAdapter<ProfileCompact, SearchViewHolder>(diffUtilCallback) {

    var onPostClick: (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding: ViewCardProfileCompactBinding =
            ViewCardProfileCompactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return SearchViewHolder(binding, onPostClick)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let { profile ->
            holder.bind(profile)
        }
    }
}