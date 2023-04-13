package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import ru.ageev.android_homework2.databinding.ActivityImagesBinding
import ru.ageev.android_homework2.images_screen.ImagesAdapter
import ru.ageev.android_homework2.images_screen.ImagesDataScreen

class ImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImagesBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ImagesAdapter()
        binding.recyclerViewImages.adapter = adapter
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ImagesActivity::class.java)
        }
    }

}