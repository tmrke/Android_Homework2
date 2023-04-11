package ru.ageev.android_homework2.first_screen.collage

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
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
}