package ru.ageev.android_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

//    private val binding: ActivityMainBinding by viewBinding(createMethod = CreateMethod.INFLATE)
//    private val viewModel: ProfileViewModel by viewModels()
//
//    private val dataList = List(30) { ImageData() }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(binding.root)
//
//        val profileAdapter = ProfileAdapter(listOf(ProfileData()))
//        val collageAdapter = CollageAdapter(listOf(CollageData()))
//        val postAdapter = PostAdapter()
//
//        postAdapter.submitList(listOf(PostData(), PostData(), PostData()))
//
//        collageAdapter.onClick = {
//            startActivity(ImagesActivity.createIntent(this, dataList))
//        }
//
//        postAdapter.onClick = {
//            startActivity(PostActivity.createIntent(this, PostData()))
//        }
//
//        binding.recyclerView.adapter = ConcatAdapter(profileAdapter, collageAdapter, postAdapter)
//
//        viewModel.getProfile()
//    }
}