package ru.ageev.android_homework2.domain.profile_use_case

import ru.ageev.android_homework2.data.remote.model.EditProfileRequest
import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import javax.inject.Inject

class EditProfileUseCase @Inject constructor(
    private var profileRepository: ProfileRepository
) {
    suspend fun execute(editProfileRequest: EditProfileRequest) {
        profileRepository.editProfile(editProfileRequest)
    }
}