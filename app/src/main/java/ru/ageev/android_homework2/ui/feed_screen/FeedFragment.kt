package ru.ageev.android_homework2.ui.feed_screen

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentFeedBinding
import ru.ageev.android_homework2.ui.insets.Inset
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsAdapter

@AndroidEntryPoint
class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val binding by viewBinding(FragmentFeedBinding::bind)
    private val viewModel by viewModels<FeedViewModel>()
    private val adapter = PostsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)

        Inset.setInsets(binding.root)
        viewModel.getFeed()
        binding.recyclerView.adapter = adapter

        viewModel.postsLiveData.observe(viewLifecycleOwner) { posts ->
            adapter.submitData(viewLifecycleOwner.lifecycle, posts)
        }

        adapter.onPostClick = { postId ->
            navController.navigate(
                FeedFragmentDirections.actionFeedFragmentToPostFragment(postId)
            )
        }

        adapter.onProfileClick = { username ->
            navController.navigate(
                FeedFragmentDirections.actionFeedFragmentToMyProfileFragment(username)
            )
        }

        binding.toolBar.menu.findItem(R.id.searchMenu).setOnMenuItemClickListener {
            navController.navigate(R.id.searchFragment)

            return@setOnMenuItemClickListener true
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottomMenuProfile -> {
                    navController.navigate(R.id.myProfileFragment)
                    true
                }

                else -> {
                    true
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())
            if (navController.currentDestination?.id == R.id.feedFragment) {
                navController.navigate(R.id.myProfileFragment)
            }
        }


    }
}