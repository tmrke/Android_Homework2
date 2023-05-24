package ru.ageev.nanopost.domain.profile_use_case

import ru.ageev.nanopost.domain.repository.ProfileRepository
import javax.inject.Inject

class UnsubscribeUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun execute(profileId: String) {
        profileRepository.unsubscribe(profileId)
    }
}