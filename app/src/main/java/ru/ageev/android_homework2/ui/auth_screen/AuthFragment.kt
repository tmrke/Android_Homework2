package ru.ageev.android_homework2.ui.auth_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.HttpException
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.databinding.FragmentAuthorizationBinding
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_authorization) {
    private val binding by viewBinding(FragmentAuthorizationBinding::bind)
    private val authViewModel by viewModels<AuthViewModel>()

    @Inject
    lateinit var responseCodeLiveData: MutableLiveData<Int>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->         //IME - клавиатура
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())

            binding.root.updatePadding(
                bottom = imeInsets.bottom,
            )

            WindowInsetsCompat.Builder()
                .setInsets(
                    WindowInsetsCompat.Type.ime(),
                    Insets.of(imeInsets.left, imeInsets.right, imeInsets.right, imeInsets.bottom)
                ).build()
        }

        var resultEnum = ResultEnum.ToCheckUsername


        with(binding) {
            buttonContinue.setOnClickListener {
                when (resultEnum) {
                    ResultEnum.ToCheckUsername -> {
                        val username = binding.editTextUsername.text.toString()

                        if (username.length < 3 || username.length > 16) {
                            with(textInputLayoutTextUsername) {
                                error = getString(R.string.short_length_username)
                                setErrorIconDrawable(R.drawable.ic_warning)
                            }
                        } else {
                            with(textInputLayoutTextUsername) {
                                error = null
                                setErrorIconDrawable(R.drawable.ic_cancel)
                            }

                            authViewModel.checkUsername(username)
                            textInputLayoutTextPassword.visibility = View.VISIBLE
                        }
                    }

                    ResultEnum.ToRegister -> {
                        val passwordLength = editTextPassword.text.toString().length

                        if (passwordLength < 8) {
                            with(textInputLayoutTextPassword) {
                                error = context.getString(R.string.short_password_warning)
                            }

                            resultEnum = ResultEnum.ToCheckUsername
                        } else if (passwordLength >= 16) {
                            with(textInputLayoutTextPassword) {
                                error = context.getString(R.string.long_password_warning)
                            }

                            resultEnum = ResultEnum.ToCheckUsername
                        } else {
                            with(textInputLayoutTextPassword) {
                                error = null
                            }

                            resultEnum = ResultEnum.ToPasswordConfirm
                        }
                    }

                    ResultEnum.ToPasswordConfirm -> {
                        if (editTextPassword.text.toString() == editTextPasswordConfirm.text.toString()) {

                            with(textInputLayoutTextPasswordConfirm) {
                                error = null
                            }

                            val registrationRequest = RegistrationRequest(
                                editTextUsername.text.toString(),
                                editTextPasswordConfirm.text.toString()
                            )

                            authViewModel.register(registrationRequest)
                        } else {
                            with(textInputLayoutTextPasswordConfirm) {
                                error = context.getString(R.string.passwords_must_coincide)
                            }
                        }
                    }

                    ResultEnum.ToLogin -> {
                        responseCodeLiveData.observe(viewLifecycleOwner) { response ->
                            val registrationRequest =
                                RegistrationRequest(
                                    editTextUsername.text.toString(),
                                    editTextPassword.text.toString()
                                )

                            authViewModel.login(registrationRequest)

                            if (response == 400) {
                                with(textInputLayoutTextPassword) {
                                    error = context.getString(R.string.incorrect_password)
                                }
                            } else {
                                with(textInputLayoutTextPassword) {
                                    error = null
                                }
                            }
                        }
                    }
                }
            }


            authViewModel.checkUsernameLiveData.observe(viewLifecycleOwner) { response ->
                when (response) {

                    CheckUsernameEnumResponse.Taken -> {
                        resultEnum = ResultEnum.ToLogin
                        binding.textInputLayoutTextPasswordConfirm.visibility = View.GONE
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

        authViewModel.registerLiveData.observe(viewLifecycleOwner) {
            navController.navigate(R.id.profileFragment)
        }


        authViewModel.loginLiveData.observe(viewLifecycleOwner) {


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
