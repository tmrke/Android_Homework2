package ru.ageev.android_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import ru.ageev.android_homework2.databinding.ActivityMainBinding
import ru.ageev.android_homework2.first_screen.images.ImagesAdapter
import ru.ageev.android_homework2.first_screen.post.PostAdapter
import ru.ageev.android_homework2.first_screen.profile.ProfileAdapter
import ru.ageev.android_homework2.images_screen.ViewImagesCardScreen

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView

        val profileAdapter = ProfileAdapter()
        val imagesAdapter = ImagesAdapter()
        val postAdapter = PostAdapter()

        imagesAdapter.onClick = { startActivity(ViewImagesCardScreen.createIntent(this)) }

        val concatAdapter = ConcatAdapter(profileAdapter, imagesAdapter, postAdapter)
        recyclerView.adapter = concatAdapter
    }
}