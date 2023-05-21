package ru.ageev.nanopost.ui.profile_screen.my_profile

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
import ru.ageev.nanopost.R
import ru.ageev.nanopost.databinding.FragmentMyProfileBinding
import ru.ageev.nanopost.ui.insets.Inset
import ru.ageev.nanopost.ui.profile_screen.MyProfileViewModel
import ru.ageev.nanopost.ui.profile_screen.collage.CollageAdapter
import ru.ageev.nanopost.ui.profile_screen.posts.PostsAdapter

@AndroidEntryPoint
class MyProfileFragment : Fragment(R.layout.fragment_my_profile) {
    private val binding by viewBinding(FragmentMyProfileBinding::bind)
    private val myProfileViewModel by viewModels<MyProfileViewModel>()

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

        val username = myProfileViewModel.getUsername()
        val argumentUsername = arguments?.getString("profileId")

        myProfileViewModel.getProfile(
            argumentUsername ?: username
        )

        if (argumentUsername != null) {
            binding.toolBar.menu.findItem(R.id.actionExit).isVisible = false

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                navController.popBackStack()
            }
        } else {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                requireActivity().moveTaskToBack(true)
            }
        }

        myProfileViewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            myProfileViewModel.loadPosts(profile.id)

            val myProfileAdapter = MyProfileAdapter()
            val postsAdapter = PostsAdapter()
            val collageAdapter = CollageAdapter()

            myProfileAdapter.isMyProfile = argumentUsername == null
            myProfileAdapter.profile = profile

            myProfileAdapter.onEditClick = {
                navController.navigate(
                    MyProfileFragmentDirections.actionProfileFragmentToEditFragment(
                        profile.avatarSmall.toString(),
                        profile.displayName ?: username,
                        profile.bio ?: "",
                        profile.id
                    )
                )
            }

            myProfileAdapter.onSubscribeClick = {
                myProfileViewModel.subscribe(profile.id)
            }

            myProfileAdapter.onUnsubscribeClick = {
                myProfileViewModel.unsubscribe(profile.id)
            }

            postsAdapter.onPostClick = { postId ->
                navController.navigate(
                    MyProfileFragmentDirections.actionProfileFragmentToPostFragment(postId)
                )
            }

            collageAdapter.profile = profile

            collageAdapter.onClick = {
                navController.navigate(
                    MyProfileFragmentDirections.actionMyProfileFragmentToImagesFragment(profile.id)
                )
            }

            val concatAdapter = ConcatAdapter(myProfileAdapter, collageAdapter, postsAdapter)

            myProfileViewModel.postsLiveData.cachedIn(viewLifecycleOwner.lifecycleScope)
                .observe(viewLifecycleOwner) { posts ->
                    postsAdapter.submitData(viewLifecycleOwner.lifecycle, posts)
                }

            binding.recyclerView.adapter = concatAdapter

            binding.swipeRefreshLayout.setOnRefreshListener {
                postsAdapter.refresh()
                myProfileViewModel.getProfile(myProfileViewModel.getUsername())

                return@setOnRefreshListener
            }
        }

        binding.bottomNavigationView.menu.findItem(R.id.bottomMenuProfile)
            .setOnMenuItemClickListener {
                if (argumentUsername != null) {
                    navController.navigate(R.id.myProfileFragment)
                }

                return@setOnMenuItemClickListener true
            }

        if (argumentUsername == null) {
            binding.bottomNavigationView.menu.findItem(R.id.bottomMenuProfile).isChecked = true
        } else {
            binding.bottomNavigationView.menu.findItem(R.id.bottomMenuFeed).isChecked = true
        }

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.createPostFragment)
        }

        binding.toolBar.menu.findItem(R.id.actionExit).setOnMenuItemClickListener {
            myProfileViewModel.deleteToken()
            navController.navigate(R.id.authFragment)

            true
        }
    }
}