package ru.ageev.nanopost.domain

import ru.ageev.nanopost.data.PrefsStorage

import javax.inject.Inject

class GetUsernameUseCase @Inject constructor(
    private val prefsStorage: PrefsStorage
) {
    fun execute(): String {
        return prefsStorage.username.toString()
    }
}