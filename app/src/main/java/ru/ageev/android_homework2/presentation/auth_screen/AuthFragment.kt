package ru.ageev.android_homework2.presentation.auth_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.databinding.FragmentAuthorizationBinding
import ru.ageev.android_homework2.presentation.profile_screen.posts.PostsViewModel

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val viewModel by viewModels<AuthViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.checkUsernameLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                CheckUsernameEnumResponse.TooShort -> Toast.makeText(context,response.name,Toast.LENGTH_LONG).show()
                CheckUsernameEnumResponse.TooLong -> Toast.makeText(context,response.name,Toast.LENGTH_LONG).show()
                CheckUsernameEnumResponse.InvalidCharacters -> Toast.makeText(context,response.name,Toast.LENGTH_LONG).show()
                CheckUsernameEnumResponse.Taken -> Toast.makeText(context,response.name,Toast.LENGTH_LONG).show()
                CheckUsernameEnumResponse.Free -> Toast.makeText(context,response.name,Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonContinue.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            viewModel.checkUsername(username)
        }
    }
}