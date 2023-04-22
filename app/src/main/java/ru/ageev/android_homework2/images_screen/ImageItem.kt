package ru.ageev.android_homework2.images_screen

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import ru.ageev.android_homework2.databinding.ItemImageBinding


class ImageItem @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet?,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {

    private var binding: ItemImageBinding

    init {
        binding = ItemImageBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setImage(url: String) {
        binding.image.load(url)
    }


}