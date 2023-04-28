package ru.ageev.android_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.databinding.ActivityMainBinding
import ru.ageev.android_homework2.presentation.first_screen.collage.CollageAdapter
import ru.ageev.android_homework2.data.CollageData
import ru.ageev.android_homework2.presentation.first_screen.post.PostAdapter
import ru.ageev.android_homework2.data.PostData
import ru.ageev.android_homework2.presentation.first_screen.profile.ProfileAdapter
import ru.ageev.android_homework2.presentation.first_screen.profile.ProfileData
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.presentation.first_screen.profile.ProfileViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val viewModel: ProfileViewModel by viewModels()

    private val dataList = List(30) { ImageData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        viewModel.getProfile()

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

        binding.recyclerView.adapter = ConcatAdapter(profileAdapter, collageAdapter, postAdapter)
    }
}