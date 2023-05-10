package ru.ageev.android_homework2.presentation.post_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.FragmentPostBinding
import ru.ageev.android_homework2.presentation.profile_screen.posts.PostsViewModel

@AndroidEntryPoint
class PostFragment : Fragment(R.layout.fragment_post) {
    private val binding by viewBinding(FragmentPostBinding::bind)
    private val viewModel by viewModels<PostViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.profileFragment)
        }

        viewModel.getPost(postId = "1")

        viewModel.postsLiveData.observe(viewLifecycleOwner) { post ->
            //TODO pressLike(post)

            pressLike(post)

        }
    }

    private fun pressLike(item: Post) {
        with(binding) {
            imageButtonFavorite.setOnClickListener {
                if (item.likes.liked) {
                    imageButtonFavorite.text = item.likes.likesCount.toString()
                    imageButtonFavorite.setIconResource(R.drawable.favorite)
                } else {
                    imageButtonFavorite.text = (item.likes.likesCount + 1).toString()
                    imageButtonFavorite.setIconResource(R.drawable.heart)
                }

                item.likes.liked = !item.likes.liked
            }

            imageButtonFavorite.text = item.likes.likesCount.toString()
        }
    }
}