package ru.ageev.android_homework2.ui.creator_post_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentAuthorizationBinding
import ru.ageev.android_homework2.databinding.FragmentCreatorPostBinding
import ru.ageev.android_homework2.ui.auth_screen.AuthViewModel

class CreatorPostFragment : Fragment(R.layout.fragment_creator_post) {
    private val binding by viewBinding(FragmentCreatorPostBinding::bind)
    private val authViewModel by viewModels<CreatorPostViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}