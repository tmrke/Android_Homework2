package ru.ageev.android_homework2.first_screen.images


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView.Adapter
import ru.ageev.android_homework2.databinding.ViewImagesCardBinding

class ImagesAdapter :
    Adapter<ImagesViewHolder>() {
    var imagesViewHolder: ImagesViewHolder? = null
    var buttonImages: Button ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding =
            ViewImagesCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val viewHolder = ImagesViewHolder(binding)
        imagesViewHolder = viewHolder

        return viewHolder
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        buttonImages = holder.buttonImages
    }

    fun getButton(): Button? {
        return buttonImages
    }
}