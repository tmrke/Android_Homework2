package ru.ageev.android_homework2.ui.profile_screen.collage


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding
import javax.inject.Inject

class CollageAdapter @Inject constructor(
    private val images: List<ImageData>
) :
    RecyclerView.Adapter<CollageViewHolder>() {
    var onClick: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollageViewHolder {
        val binding =
            ViewCollageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CollageViewHolder(binding, onClick, parent.context)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: CollageViewHolder, position: Int) {
        holder.bind(images[position])
    }
}