package ru.ageev.android_homework2.first_screen.images

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import ru.ageev.android_homework2.databinding.ViewImagesCardBinding

class ViewImagesCard @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {
    private var binding: ViewImagesCardBinding

    init {
        binding = ViewImagesCardBinding.inflate(LayoutInflater.from(context), this, true)

    }
}