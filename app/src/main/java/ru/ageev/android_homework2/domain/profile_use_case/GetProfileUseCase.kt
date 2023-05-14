package ru.ageev.android_homework2.domain.profile_use_case

import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    suspend fun execute(profileId: String): Profile {
        return repository.getProfile(profileId)
    }
}