package ru.ageev.nanopost.domain.auth_use_case
import ru.ageev.nanopost.data.PrefsStorage
import javax.inject.Inject

class DeleteTokenUseCase @Inject constructor(
    private val prefsStorage: PrefsStorage
) {
    fun execute() {
        prefsStorage.token = null
    }
}