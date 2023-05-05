package ru.ageev.android_homework2.presentation.auth_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.ageev.android_homework2.domain.RegisterUseCase
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    fun checkUsername(username: String) {
        registerUseCase.execute(username)
    }
}