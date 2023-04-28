package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.mappers.ProfileMapper
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.remote.NanopostApiService
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: NanopostApiService,
    private val mappers: ProfileMapper
) : ProfileRepository {
    override suspend fun getProfile(profilerId: String): Profile {
        return mappers.toProfile(apiService.getProfile(profilerId))
    }
}