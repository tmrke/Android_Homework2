package ru.ageev.nanopost.domain.profile_use_case

import ru.ageev.nanopost.data.model.Profile
import ru.ageev.nanopost.data.repository.ProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    suspend fun execute(profileId: String): Profile {
        return repository.getProfile(profileId)
    }
}