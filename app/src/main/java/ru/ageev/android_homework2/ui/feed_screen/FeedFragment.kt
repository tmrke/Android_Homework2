package ru.ageev.android_homework2.ui.feed_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentFeedBinding
import ru.ageev.android_homework2.databinding.FragmentImagesBinding
import ru.ageev.android_homework2.ui.profile_screen.posts.PostsAdapter
import ru.ageev.android_homework2.ui.profile_screen.profile.ProfileViewModel

@AndroidEntryPoint
class FeedFragment : Fragment(R.layout.fragment_feed) {
    private val binding by viewBinding(FragmentFeedBinding::bind)
    private val viewModel by viewModels<FeedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        binding.bottomNavigationView.menu.findItem(R.id.bottomMenuFeed).isChecked = true


        viewModel.getFeed()

        val adapter = PostsAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.postsLiveData.observe(viewLifecycleOwner) { posts ->
            adapter.submitData(viewLifecycleOwner.lifecycle, posts)
        }

        binding.bottomNavigationView.menu.findItem(R.id.bottomMenuProfile)
            .setOnMenuItemClickListener {
                navController.navigate(R.id.profileFragment)

                true
            }
    }
}