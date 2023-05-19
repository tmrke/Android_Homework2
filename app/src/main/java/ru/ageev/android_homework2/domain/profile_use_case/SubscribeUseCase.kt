package ru.ageev.android_homework2.domain.profile_use_case

import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import javax.inject.Inject

class SubscribeUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun execute(profileId: String) {
        profileRepository.subscribe(profileId)
    }
}