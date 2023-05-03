package ru.ageev.android_homework2.presentation.post_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.FragmentPostBinding

class PostFragment : Fragment(R.layout.fragment_post) {
    private val binding by viewBinding(FragmentPostBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        val post: Post = Post()

        with(binding) {
            imageViewMedia.load(post.postImageUrl)
            textViewDate.text = post.date
            textViewPostText.text = post.text
            imageViewPostProfileImage.load(post.profileImageUrl)

            toolBar.setNavigationOnClickListener {
                navController.navigate(R.id.profileFragment)
            }
        }
    }
}