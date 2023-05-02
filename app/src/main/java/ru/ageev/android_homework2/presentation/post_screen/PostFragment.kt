package ru.ageev.android_homework2.presentation.post_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.PostData
import ru.ageev.android_homework2.databinding.FragmentPostBinding

class PostFragment : Fragment(R.layout.fragment_post) {
    private val binding by viewBinding(FragmentPostBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        val postData: PostData = PostData()

        with(binding) {
            imageViewMedia.load(postData.postImageUrl)
            textViewDate.text = postData.date
            textViewPostText.text = postData.text
            imageViewPostProfileImage.load(postData.profileImageUrl)

            toolBar.setNavigationOnClickListener {
                navController.navigate(R.id.profileFragment)
            }
        }
    }
}