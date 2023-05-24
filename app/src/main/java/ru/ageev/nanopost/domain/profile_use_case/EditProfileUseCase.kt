package ru.ageev.nanopost.domain.profile_use_case

import ru.ageev.nanopost.data.remote.model.EditProfileRequest
import ru.ageev.nanopost.data.repository.ProfileRepository
import javax.inject.Inject

class EditProfileUseCase @Inject constructor(
    private var profileRepository: ProfileRepository
) {
    suspend fun execute(editProfileRequest: EditProfileRequest) {
        profileRepository.editProfile(editProfileRequest)
    }
}