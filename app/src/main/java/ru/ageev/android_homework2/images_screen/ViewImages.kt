package ru.ageev.android_homework2.images_screen

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.ViewImagesBinding

class ViewImages @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {
    private var binding: ViewImagesBinding

    init {
        binding = ViewImagesBinding.inflate(LayoutInflater.from(context), this, true)
    }
}