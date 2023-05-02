package ru.ageev.android_homework2.presentation.profile_screen.collage


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.data.CollageData
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

class CollageAdapter(private val collages: List<CollageData>) :
    RecyclerView.Adapter<CollageViewHolder>() {
    var onClick: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollageViewHolder {
        val binding =
            ViewCollageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CollageViewHolder(binding, onClick, parent.context)
    }

    override fun getItemCount(): Int {
        return collages.size
    }

    override fun onBindViewHolder(holder: CollageViewHolder, position: Int) {
        holder.bind(collages[position])
    }
}