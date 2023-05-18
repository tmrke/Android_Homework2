package ru.ageev.android_homework2.ui.profile_screen.my_profile

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
import ru.ageev.android_homework2.databinding.FragmentMyProfileBinding
import ru.ageev.android_homework2.ui.insets.Inset
import ru.ageev.android_homework2.ui.profile_screen.MyProfileViewModel
import ru.ageev.android_homework2.ui.profile_screen.collage.CollageAdapter
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsAdapter

@AndroidEntryPoint
class MyProfileFragment : Fragment(R.layout.fragment_profile) {
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

        myProfileViewModel.profileLiveData.observe(viewLifecycleOwner) { profile ->
            myProfileViewModel.loadPosts(profile.id)

            val myProfileAdapter = MyProfileAdapter(profile)
            val postsAdapter = PostsAdapter()
            val collageAdapter = CollageAdapter(List(4) { ImageData() })

            myProfileAdapter.isMyProfile = argumentUsername == null

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

            postsAdapter.onPostClick = { postId ->
                navController.navigate(
                    MyProfileFragmentDirections.actionProfileFragmentToPostFragment(postId)
                )
            }

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
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            myProfileViewModel.loadPosts(myProfileViewModel.getUsername())

            //TODO Paging обновить через адаптер (типа adapter.load)

            myProfileViewModel.getProfile(myProfileViewModel.getUsername())

            binding.swipeRefreshLayout.isRefreshing = false
        }

        if (argumentUsername == null) {
            binding.bottomNavigationView.menu.findItem(R.id.bottomMenuProfile).isChecked = true
        } else {
            binding.bottomNavigationView.menu.findItem(R.id.bottomMenuFeed).isChecked = true
        }

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