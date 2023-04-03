package ru.ageev.android_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ageev.android_homework2.databinding.ActivityMainBinding
import ru.ageev.android_homework2.images.ImagesAdapter
import ru.ageev.android_homework2.post.PostAdapter
import ru.ageev.android_homework2.profile.ProfileAdapter

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

        val concatAdapter = ConcatAdapter(profileAdapter, imagesAdapter, postAdapter)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = concatAdapter
    }
}