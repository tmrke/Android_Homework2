package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ageev.android_homework2.databinding.ActivityImagesBinding

import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.presentation.images_screen.ImagesAdapter

class ImagesActivity : AppCompatActivity() {
    private val binding: ActivityImagesBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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