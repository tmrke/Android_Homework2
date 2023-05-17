package ru.ageev.android_homework2.ui.profile

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.cachedIn
import androidx.recyclerview.widget.ConcatAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.databinding.FragmentProfileBinding
import ru.ageev.android_homework2.ui.insets.Inset
import ru.ageev.android_homework2.ui.post_screen.PostViewModel
import ru.ageev.android_homework2.ui.profile_screen.collage.CollageAdapter
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsAdapter
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsViewModel

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_my_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val myProfileViewModel by viewModels<ProfileViewModel>()
    private val postsViewModel by viewModels<PostsViewModel>()
    private val postViewModel by viewModels<PostViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        Inset.setInsets(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottomMenuFeed -> {
                    navController.navigate(R.id.feedFragment)
                    true
                }

                else -> {
                    true
                }
            }
        }


        myProfileViewModel.getProfile(
            myProfileViewModel.getUsername()
            //"evo"
        )

        myProfileViewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            postsViewModel.loadPosts(profile.id)

            val myProfileAdapter = ProfileAdapter(profile)
            val postsAdapter = PostsAdapter()
            val collageAdapter = CollageAdapter(List(4) { ImageData() })


            myProfileAdapter.onClick = {
                navController.navigate(R.id.editFragment)
            }

//            postsAdapter.onClick = { postId ->
//                postViewModel.getPost(postId)
//
//                navController.navigate(
//                    ProfileFragmentDirections.actionProfileFragmentToPostFragment(postId)
//                )
//            }
//
//            collageAdapter.onClick = {
//                navController.navigate(
//                    ProfileFragmentDirections.actionProfileFragmentToImagesFragment(profile.id)
//                )
//            }

            val concatAdapter = ConcatAdapter(myProfileAdapter, collageAdapter, postsAdapter)

            postsViewModel.postsLiveData.cachedIn(viewLifecycleOwner.lifecycleScope)
                .observe(viewLifecycleOwner) { posts ->
                    postsAdapter.submitData(viewLifecycleOwner.lifecycle, posts)
                }

            binding.recyclerView.adapter = concatAdapter
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            postsViewModel.loadPosts(myProfileViewModel.getUsername())
            binding.swipeRefreshLayout.isRefreshing = false
        }

        binding.bottomNavigationView.menu.findItem(R.id.bottomMenuProfile).isChecked = true

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.createPostFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().moveTaskToBack(true)
        }

        binding.toolBar.menu.findItem(R.id.actionExit).setOnMenuItemClickListener {
            myProfileViewModel.deleteToken()
            navController.navigate(R.id.authFragment)

            true
        }
    }
}