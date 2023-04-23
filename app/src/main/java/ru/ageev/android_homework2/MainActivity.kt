package ru.ageev.android_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import ru.ageev.android_homework2.databinding.ActivityMainBinding
import ru.ageev.android_homework2.first_screen.collage.CollageAdapter
import ru.ageev.android_homework2.first_screen.collage.CollageData
import ru.ageev.android_homework2.first_screen.post.PostAdapter
import ru.ageev.android_homework2.first_screen.post.PostData
import ru.ageev.android_homework2.first_screen.profile.ProfileAdapter
import ru.ageev.android_homework2.first_screen.profile.ProfileData
import ru.ageev.android_homework2.images_screen.ImageData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //TODO поменять на делегат

    private val dataList = List(30) { ImageData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileAdapter = ProfileAdapter(listOf(ProfileData()))
        val collageAdapter = CollageAdapter(listOf(CollageData()))
        val postAdapter = PostAdapter()

        postAdapter.submitList(listOf(PostData(), PostData(), PostData()))

        collageAdapter.onClick = {
            startActivity(ImagesActivity.createIntent(this, dataList))
        }

        postAdapter.onClick = {
            startActivity(PostActivity.createIntent(this, PostData()))
        }

        binding.recyclerView.adapter =  ConcatAdapter(profileAdapter, collageAdapter, postAdapter)
    }
}