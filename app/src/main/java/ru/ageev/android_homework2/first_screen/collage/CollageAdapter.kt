package ru.ageev.android_homework2.first_screen.collage


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

val diffUtilCallback = object : DiffUtil.ItemCallback<CollageData>() {
    override fun areItemsTheSame(oldItem: CollageData, newItem: CollageData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CollageData, newItem: CollageData): Boolean {
        return oldItem == newItem
    }
}

class CollageAdapter : ListAdapter<CollageData, CollageViewHolder>(diffUtilCallback) {
    var onClick: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollageViewHolder {
        val binding =
            ViewCollageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CollageViewHolder(binding, onClick, parent.context)
    }

    override fun onBindViewHolder(holder: CollageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}