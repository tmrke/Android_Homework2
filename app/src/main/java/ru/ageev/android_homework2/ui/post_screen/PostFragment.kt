package ru.ageev.android_homework2.ui.post_screen

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.FragmentPostBinding

@AndroidEntryPoint
class PostFragment : Fragment(R.layout.fragment_post) {
    private val binding by viewBinding(FragmentPostBinding::bind)
    private val viewModel by viewModels<PostViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)

        val postId = arguments?.getString("postId")

        if (postId != null) {
            viewModel.getPost(postId)

            binding.toolBar.menu.findItem(R.id.actionDelete).let { icon ->
                icon.setOnMenuItemClickListener {

                    viewModel.deletePost(postId)
                    navController.navigate(R.id.profileFragment)

                    true
                }
            }
        }

        viewModel.postLiveData.observe(viewLifecycleOwner) { post ->
            binding.textViewPostText.text = post.text

//            if (post.images != null) {
//                for (i in post.images.indices) {
//                    val imageUrl = post.images[i].images[0].url
//                    val imageView = when (i) {
//                        0 -> binding.imageViewMedia1
//                        1 -> binding.imageViewMedia2
//                        2 -> binding.imageViewMedia3
//                        3 -> binding.imageViewMedia4
//                        else -> null
//                    }
//
//                    imageView?.load(imageUrl)
//                }
//            }

            clickLike(post)
        }

        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.profileFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())
            if (navController.currentDestination?.id == R.id.postFragment) {
                navController.navigate(R.id.profileFragment)
            }
        }
    }

    private fun clickLike(post: Post) {
        with(binding) {
            imageButtonFavorite.setIconResource(
                if (post.likes.liked) {
                    R.drawable.heart
                } else {
                    R.drawable.favorite
                }
            )

            imageButtonFavorite.text = post.likes.likesCount.toString()

            imageButtonFavorite.setOnClickListener {
                if (post.likes.liked) {
                    imageButtonFavorite.text = post.likes.likesCount.toString()
                    imageButtonFavorite.setIconResource(R.drawable.favorite)
                } else {
                    imageButtonFavorite.text = (post.likes.likesCount + 1).toString()
                    imageButtonFavorite.setIconResource(R.drawable.heart)
                }

                post.likes.liked = !post.likes.liked
            }
        }
    }
}