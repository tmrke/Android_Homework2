package ru.ageev.android_homework2.ui.edit_screen

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.remote.model.EditProfileRequest
import ru.ageev.android_homework2.domain.GetContentUriUseCase
import ru.ageev.android_homework2.domain.profile_use_case.EditProfileUseCase
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val editProfileUseCase: EditProfileUseCase,
    private val getContentUriUseCase: GetContentUriUseCase
) : ViewModel() {
    fun editProfile(editProfileRequest: EditProfileRequest) {
        viewModelScope.launch {
            editProfileUseCase.execute(editProfileRequest)
        }
    }

    fun getContent(uri: Uri?): ByteArray? {
        return getContentUriUseCase.invoke(uri)
    }
}