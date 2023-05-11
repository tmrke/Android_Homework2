package ru.ageev.android_homework2.ui.profile_screen.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ConcatAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentProfileBinding
import ru.ageev.android_homework2.ui.post_screen.PostViewModel
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsAdapter
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsViewModel

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val profileViewModel by viewModels<ProfileViewModel>()
    private val postsViewModel by viewModels<PostsViewModel>()
    private val postViewModel by viewModels<PostViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

//        val collageAdapter = CollageAdapter(listOf(CollageData()))
//
//        collageAdapter.onClick = {
//            navController.navigate(R.id.imagesFragment)
//        }

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.createPostFragment)
        }


        profileViewModel.getProfile(
            //profileViewModel.getUsername()
            "evo"
        )

        profileViewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            postsViewModel.loadPosts(profile.id)
        }

        profileViewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            val profileAdapter = ProfileAdapter(profile)
            val postsAdapter = PostsAdapter(postViewModel)

            postsAdapter.onClick = { postId ->
                navController.navigate(
                    ProfileFragmentDirections.actionProfileFragmentToPostFragment(postId)
                )
            }

            val concatAdapter = ConcatAdapter(profileAdapter, postsAdapter)

            postsViewModel.postsLiveData.observe(viewLifecycleOwner) { posts ->
                postsAdapter.submitData(viewLifecycleOwner.lifecycle, posts)
            }

            binding.recyclerView.adapter = concatAdapter
        }
    }
}