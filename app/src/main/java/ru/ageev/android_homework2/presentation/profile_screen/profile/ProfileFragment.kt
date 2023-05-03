package ru.ageev.android_homework2.presentation.profile_screen.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ConcatAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.CollageData
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.FragmentProfileBinding
import ru.ageev.android_homework2.presentation.profile_screen.collage.CollageAdapter
import ru.ageev.android_homework2.presentation.profile_screen.posts.PostsAdapter
import ru.ageev.android_homework2.presentation.profile_screen.posts.PostsViewModel

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val profileViewModel by viewModels<ProfileViewModel>()
    private val postsViewModel by viewModels<PostsViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        val collageAdapter = CollageAdapter(listOf(CollageData()))

        collageAdapter.onClick = {
            navController.navigate(R.id.imagesFragment)
        }

        profileViewModel.getProfile()
        postsViewModel.getPosts()

        postsViewModel.postsLiveData.observe(viewLifecycleOwner) { post ->
            val postsAdapter = PostsAdapter(post)

            postsAdapter.onClick = {
                navController.navigate(R.id.postFragment)
            }
        }


        profileViewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            val profileAdapter = ProfileAdapter(profile)
            binding.recyclerView.adapter =
                ConcatAdapter(profileAdapter)
        }
    }
}