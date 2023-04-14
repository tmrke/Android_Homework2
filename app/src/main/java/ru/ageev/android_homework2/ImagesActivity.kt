package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import ru.ageev.android_homework2.databinding.ActivityImagesBinding
import ru.ageev.android_homework2.images_screen.ImageData
import ru.ageev.android_homework2.images_screen.ImageItem
import ru.ageev.android_homework2.images_screen.ImagesAdapter

class ImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImagesBinding

    private val dataList = mutableListOf<ImageData>().apply {
        repeat(30) {
            add(ImageData())
        }
    }

    private val listAdapter by lazy {
        ImagesAdapter(dataList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewImages.adapter = listAdapter
        setContentView(binding.root)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ImagesActivity::class.java)
        }
    }

}