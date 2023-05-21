package ru.ageev.nanopost.ui.edit_screen

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.nanopost.data.remote.model.EditProfileRequest
import ru.ageev.nanopost.domain.GetContentUriUseCase
import ru.ageev.nanopost.domain.profile_use_case.EditProfileUseCase
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