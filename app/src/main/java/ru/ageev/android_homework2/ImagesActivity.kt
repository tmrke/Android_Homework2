package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import ru.ageev.android_homework2.databinding.ActivityImagesBinding
import ru.ageev.android_homework2.images_screen.ImageData
import ru.ageev.android_homework2.images_screen.ImagesAdapter

class ImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList =
            intent.getParcelableArrayExtra(ARG_TEXT_KEY)?.map { it as ImageData } ?: emptyList()
        val listAdapter = ImagesAdapter(dataList)

        binding.recyclerViewImages.adapter = listAdapter

        binding.toolBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        private const val ARG_TEXT_KEY = "ARG_TEXT_KEY"

        fun createIntent(context: Context, dataList: List<ImageData>): Intent {
            return Intent(context, ImagesActivity::class.java).apply {
                putExtra(ARG_TEXT_KEY, dataList.toTypedArray())
            }
        }
    }
}
