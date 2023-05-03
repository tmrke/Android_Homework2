package ru.ageev.android_homework2.presentation.profile_screen.posts

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentPostBinding

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragment_post) {
    private val binding by viewBinding(FragmentPostBinding:: bind)
    private val viewModel by viewModels<PostsViewModel>()
}