package ru.ageev.android_homework2.ui.post_screen

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.FragmentPostBinding
import ru.ageev.android_homework2.ui.insets.Inset

@AndroidEntryPoint
class PostFragment : Fragment(R.layout.fragment_post) {
    private val binding by viewBinding(FragmentPostBinding::bind)
    private val viewModel by viewModels<PostViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController = Navigation.findNavController(view)

        Inset.setInsets(binding.root)

        val postId = arguments?.getString("postId")

        if (postId != null) {
            viewModel.getPost(postId)

            binding.toolBar.menu.findItem(R.id.actionDelete).let { icon ->
                icon.setOnMenuItemClickListener {

                    viewModel.deletePost(postId)
                    navController.navigate(R.id.myProfileFragment)

                    return@setOnMenuItemClickListener true
                }
            }
        }

        viewModel.postLiveData.observe(viewLifecycleOwner) { post ->
            binding.textViewPostText.text = post.text
            binding.textViewDate.text = post.dateCreated
            binding.textViewProfileName.text = post.owner.displayName
            binding.imageViewPostProfileImage.load(post.owner.avatarUrl)

            binding.imageViewMedia1.visibility = View.GONE
            binding.imageViewMedia2.visibility = View.GONE
            binding.imageViewMedia3.visibility = View.GONE
            binding.imageViewMedia4.visibility = View.GONE

            if (post.images != null) {
                for (i in post.images.indices) {

                    val imageUrl = post.images[i].sizes[0].url
                    val imageView = when (i) {
                        0 -> binding.imageViewMedia1
                        1 -> binding.imageViewMedia2
                        2 -> binding.imageViewMedia3
                        3 -> binding.imageViewMedia4
                        else -> null
                    }

                    imageView?.load(imageUrl)
                    imageView?.visibility = View.VISIBLE
                }
            }

            clickLike(post)

            binding.imageViewPostProfileImage.setOnClickListener {
                navController.navigate(
                    PostFragmentDirections.actionPostFragmentToMyProfileFragment(post.owner.id)
                )
            }

            binding.textViewProfileName.setOnClickListener {
                navController.navigate(
                    PostFragmentDirections.actionPostFragmentToMyProfileFragment(post.owner.id)
                )
            }
        }



        binding.toolBar.setNavigationOnClickListener {
            navController.navigate(R.id.myProfileFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController = Navigation.findNavController(requireView())

            if (navController.currentDestination?.id == R.id.postFragment) {
                navController.navigate(R.id.myProfileFragment)
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