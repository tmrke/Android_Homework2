package ru.ageev.nanopost.ui.insets

import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding


object Inset {
    fun setInsets(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->         //IME - клавиатура
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())

            view.updatePadding(
                bottom = imeInsets.bottom
            )

            WindowInsetsCompat.Builder()
                .setInsets(
                    WindowInsetsCompat.Type.ime(),
                    Insets.of(imeInsets.left, 0, imeInsets.right, imeInsets.bottom)
                ).build()
        }
    }
}