package ru.ageev.android_homework2.domain.profile_use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.android_homework2.data.model.ProfileCompact
import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun execute(query: String): Flow<PagingData<ProfileCompact>> {
        return profileRepository.searchProfile(query)
    }
}