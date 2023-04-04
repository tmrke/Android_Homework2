package ru.ageev.android_homework2.images_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.RecyclerViewImagesBinding


class ImagesAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewImagesViewHolder>() {
    private lateinit var binding: RecyclerViewImagesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewImagesViewHolder {
        binding =
            RecyclerViewImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RecyclerViewImagesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: RecyclerViewImagesViewHolder, position: Int) {
        val attrs = context.obtainStyledAttributes(R.styleable.RecyclerViewImages)
        val url = attrs.getString(R.styleable.RecyclerViewImages_url_image1)

        attrs.recycle()
    }
}