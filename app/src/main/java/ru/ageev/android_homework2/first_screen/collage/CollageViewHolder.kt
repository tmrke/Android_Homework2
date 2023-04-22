package ru.ageev.android_homework2.first_screen.collage

import android.content.Context
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

class CollageViewHolder(
    private val binding: ViewCollageCardBinding,
    val onClick: () -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CollageData) {
        with(binding) {
            image1.load(item.imageUrl1)
            image2.load(item.imageUrl2)
            image3.load(item.imageUrl3)
            image4.load(item.imageUrl4)

            buttonImages.setOnClickListener {
                onClick()
            }
        }
    }
}