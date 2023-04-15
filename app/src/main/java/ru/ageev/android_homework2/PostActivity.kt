package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

import androidx.appcompat.app.AppCompatActivity
import coil.load
import ru.ageev.android_homework2.databinding.ActivityPostBinding
import ru.ageev.android_homework2.first_screen.post.PostData
import ru.ageev.android_homework2.post_screen.PostItem

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postData: PostData? = intent.extras?.getParcelable(ARG_TEXT_KEY)

        with(binding) {
            imageViewMedia.load(postData?.postImageUri)
            textViewDate.text = postData?.date
            textViewPostText.text = postData?.text
            imageViewPostProfileImage.load(postData?.profileImageUri)
            binding.toolBar.setNavigationOnClickListener {
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
