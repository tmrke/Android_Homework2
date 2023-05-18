package ru.ageev.android_homework2.ui.search_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.databinding.ViewMyProfileCardBinding

val diffUtilCallback = object : DiffUtil.ItemCallback<Profile>() {
    override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
        return oldItem == newItem
    }
}

//TODO возможно что то с адаптером, не проходит код во вью холдер

class SearchAdapter :
    PagingDataAdapter<Profile, SearchViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding: ViewMyProfileCardBinding =
            ViewMyProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        getItem(position)?.let { profile ->
            holder.bind(profile)
        }
    }
}