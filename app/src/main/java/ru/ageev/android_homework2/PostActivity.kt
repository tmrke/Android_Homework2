package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import ru.ageev.android_homework2.databinding.ActivityPostBinding
import ru.ageev.android_homework2.data.PostData

class PostActivity : AppCompatActivity() {
    private val binding: ActivityPostBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val postData: PostData? = intent.extras?.getParcelable(ARG_TEXT_KEY)

        with(binding) {
            imageViewMedia.load(postData?.postImageUrl)
            textViewDate.text = postData?.date
            textViewPostText.text = postData?.text
            imageViewPostProfileImage.load(postData?.profileImageUrl)
            toolBar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    companion object {
        private const val ARG_TEXT_KEY = "ARG_TEXT_KEY"

        fun createIntent(context: Context, postData: PostData): Intent {
            return Intent(context, PostActivity::class.java).apply {
                putExtra(ARG_TEXT_KEY, postData)
            }
        }
    }
}
