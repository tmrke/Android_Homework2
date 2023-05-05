package ru.ageev.android_homework2.presentation.auth_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.FragmentAuthorizationBinding

class AuthFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username: String = binding.editText.toString()

        viewModel.checkUsername(username)


    }
}