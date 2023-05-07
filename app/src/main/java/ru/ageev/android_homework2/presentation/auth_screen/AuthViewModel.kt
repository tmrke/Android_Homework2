package ru.ageev.android_homework2.presentation.auth_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.PrefsStorage
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.domain.CheckUsernameUseCase
import ru.ageev.android_homework2.domain.RegisterUseCase
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val checkUsernameUseCase: CheckUsernameUseCase,
    private val registerUseCase: RegisterUseCase,
) : ViewModel() {

    private val _checkUsernameLiveData = MutableLiveData<CheckUsernameEnumResponse>()
    val checkUsernameLiveData: LiveData<CheckUsernameEnumResponse> = _checkUsernameLiveData


    fun checkUsername(username: String) {
        viewModelScope.launch {
            try {
                checkUsernameUseCase.execute(username).let { response ->
                    _checkUsernameLiveData.postValue(response)
                }
            } catch (e: Exception) {
                Log.e("Auth", e.message ?: "")
            }
        }
    }

    private val _registerLiveData = MutableLiveData<PrefsStorage>()
    val registerLiveData: LiveData<PrefsStorage> = _registerLiveData

    fun register(registrationRequest: RegistrationRequest) {
        viewModelScope.launch {
            try {
                //TODO подумать тут как определить полученный токен
                registerUseCase.execute(registrationRequest).let { response ->
                    _registerLiveData.postValue(response)
                }
            } catch (e: Exception) {
                Log.e("Auth", e.message ?: "")
            }
        }
    }

}