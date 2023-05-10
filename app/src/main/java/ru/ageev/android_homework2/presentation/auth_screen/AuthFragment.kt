package ru.ageev.android_homework2.presentation.auth_screen

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.Toast
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.PrefsStorage
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.databinding.FragmentAuthorizationBinding
import ru.ageev.android_homework2.presentation.profile_screen.profile.ProfileViewModel
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->         //IME - клавиатура
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())

            binding.root.updatePadding(
                bottom = imeInsets.bottom
            )

            WindowInsetsCompat.Builder()
                .setInsets(
                    WindowInsetsCompat.Type.ime(),
                    Insets.of(imeInsets.left, 0, imeInsets.right, imeInsets.bottom)
                ).build()
        }

        var resultEnum = ResultEnum.ToCheckUsername


        with(binding) {
            buttonContinue.setOnClickListener {
                when (resultEnum) {
                    ResultEnum.ToCheckUsername -> {
                        val username = binding.editTextUsername.text.toString()

                        if (username.length < 3 || username.length > 16) {
                            Toast.makeText(
                                context,
                                "usernames length must be more than 2 and less than 17",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            authViewModel.checkUsername(username)
                            textInputLayoutTextPassword.visibility = View.VISIBLE
                        }
                    }

                    ResultEnum.ToRegister -> {
                        val passwordLength = editTextPassword.text.toString().length

                        if (passwordLength < 8) {
                            Toast.makeText(
                                context,
                                "passwords length must be 8 and more",
                                Toast.LENGTH_SHORT
                            ).show()

                            resultEnum = ResultEnum.ToCheckUsername
                        } else if (passwordLength >= 16) {
                            Toast.makeText(
                                context,
                                "passwords length must be less than 16",
                                Toast.LENGTH_SHORT
                            ).show()

                            resultEnum = ResultEnum.ToCheckUsername
                        } else {
                            resultEnum = ResultEnum.ToPasswordConfirm
                        }
                    }

                    ResultEnum.ToPasswordConfirm -> {
                        if (editTextPassword.text.toString() == editTextPasswordConfirm.text.toString()) {

                            val registrationRequest = RegistrationRequest(
                                editTextUsername.text.toString(),
                                editTextPasswordConfirm.text.toString()
                            )

                            authViewModel.register(registrationRequest)
                            Toast.makeText(
                                context,
                                registrationRequest.username,
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                context,
                                "passwords must coincide",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    ResultEnum.ToLogin -> {
                        val registrationRequest =
                            RegistrationRequest(
                                editTextUsername.text.toString(),
                                editTextPassword.text.toString()
                            )

                        authViewModel.login(registrationRequest)
                    }
                }
            }


            authViewModel.checkUsernameLiveData.observe(viewLifecycleOwner) { response ->
                when (response) {

                    CheckUsernameEnumResponse.Taken -> {
                        resultEnum = ResultEnum.ToLogin
                        binding.textInputLayoutTextPasswordConfirm.visibility = View.INVISIBLE
                    }

                    CheckUsernameEnumResponse.Free -> {
                        binding.textInputLayoutTextPasswordConfirm.visibility = View.VISIBLE
                        resultEnum = ResultEnum.ToRegister
                    }

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
                }
            }
        }

        authViewModel.registerLiveData.observe(viewLifecycleOwner) { token ->
            navController.navigate(R.id.profileFragment)
        }


        authViewModel.loginLiveData.observe(viewLifecycleOwner) { token ->
            //TODO обработка неверного пароля поймать через Exception
            navController.navigate(R.id.profileFragment)
        }
    }

    enum class ResultEnum {
        ToCheckUsername,
        ToPasswordConfirm,
        ToRegister,
        ToLogin,
    }
}
