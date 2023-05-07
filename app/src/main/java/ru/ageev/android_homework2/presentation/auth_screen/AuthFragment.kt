package ru.ageev.android_homework2.presentation.auth_screen

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.compose.ui.text.resolveDefaults
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.PrefsStorage
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.databinding.FragmentAuthorizationBinding
import ru.ageev.android_homework2.presentation.profile_screen.posts.PostsViewModel

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val viewModel by viewModels<AuthViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        with(binding) {
            buttonContinue.setOnClickListener {

                val username = binding.editTextUsername.text.toString()
                viewModel.checkUsername(username)

                if (textInputLayoutTextPassword.visibility == View.VISIBLE
                    && textInputLayoutTextPasswordConfirm.visibility == View.VISIBLE
                    && editTextPassword.text.toString().isNotEmpty()
                    && editTextPasswordConfirm.text.toString().isNotEmpty()
                ) {
                    val registrationRequest = RegistrationRequest(
                        editTextUsername.text.toString(),
                        editTextPasswordConfirm.text.toString()
                    )

                    viewModel.register(registrationRequest)
                } else if (textInputLayoutTextPassword.visibility == View.VISIBLE
                ) {
                    textInputLayoutTextPasswordConfirm.visibility = View.VISIBLE
                }
            }
        }


        viewModel.checkUsernameLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                CheckUsernameEnumResponse.TooShort -> Toast.makeText(
                    context,
                    response.name,
                    Toast.LENGTH_LONG
                ).show()

                CheckUsernameEnumResponse.TooLong -> Toast.makeText(
                    context,
                    response.name,
                    Toast.LENGTH_LONG
                ).show()

                CheckUsernameEnumResponse.InvalidCharacters -> Toast.makeText(
                    context,
                    response.name,
                    Toast.LENGTH_LONG
                ).show()

                CheckUsernameEnumResponse.Taken -> Toast.makeText(
                    context,
                    response.name,
                    Toast.LENGTH_LONG
                ).show()

                CheckUsernameEnumResponse.Free -> binding.textInputLayoutTextPassword.visibility =
                    View.VISIBLE
            }
        }


//        viewModel.registerLiveData.observe(viewLifecycleOwner) { token ->
//            //TODO подумать тут как понять, что мы уже зарегистрировались
//
//            navController.navigate(R.id.profileFragment)
//        }
    }
}
