package ru.ageev.nanopost.domain.profile_use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.ProfileCompact
import ru.ageev.nanopost.data.remote.repository.ProfileRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun execute(query: String): Flow<PagingData<ProfileCompact>> {
        return profileRepository.searchProfile(query)
    }
}