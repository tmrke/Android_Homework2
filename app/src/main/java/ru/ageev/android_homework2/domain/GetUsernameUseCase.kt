package ru.ageev.android_homework2.domain

import ru.ageev.android_homework2.data.PrefsStorage

import javax.inject.Inject

class GetUsernameUseCase @Inject constructor(
    private val prefsStorage: PrefsStorage
) {
    fun execute(): String {
        return prefsStorage.username.toString()
    }
}