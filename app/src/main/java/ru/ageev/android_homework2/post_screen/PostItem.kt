package ru.ageev.android_homework2.post_screen

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import ru.ageev.android_homework2.databinding.ActivityPostBinding


class PostItem @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attrSet, defAttrsSet) {
    private var binding: ActivityPostBinding

    init {
        binding = ActivityPostBinding.inflate(LayoutInflater.from(context), this, true)
    }
}