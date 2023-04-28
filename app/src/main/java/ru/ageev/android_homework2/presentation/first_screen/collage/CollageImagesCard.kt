package ru.ageev.android_homework2.presentation.first_screen.collage

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

class CollageImagesCard @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {
    private var binding: ViewCollageCardBinding

    init {
        binding = ViewCollageCardBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setImage1Url(url: String) {
        binding.image1.load(url)
    }

    fun setImage2Url(url: String) {
        binding.image2.load(url)
    }

    fun setImage3Url(url: String) {
        binding.image3.load(url)
    }

    fun setImage4Url(url: String) {
        binding.image4.load(url)
    }


}