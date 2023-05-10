package ru.ageev.android_homework2.presentation.post_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentPostBinding

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
    }
}