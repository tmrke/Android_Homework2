package ru.ageev.android_homework2.images_screen

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import ru.ageev.android_homework2.ImagesActivity
import ru.ageev.android_homework2.databinding.ActivityImagesBinding

class ViewImagesCardScreen @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet?,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {
    private var binding: ActivityImagesBinding

    init {
        binding = ActivityImagesBinding.inflate(LayoutInflater.from(context), this, true)
    }
}