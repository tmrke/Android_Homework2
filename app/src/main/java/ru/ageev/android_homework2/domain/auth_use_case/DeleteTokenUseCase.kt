package ru.ageev.android_homework2.domain.auth_use_case
import ru.ageev.android_homework2.data.PrefsStorage
import javax.inject.Inject

class DeleteTokenUseCase @Inject constructor(
    private val prefsStorage: PrefsStorage
) {
    fun execute() {
        prefsStorage.token = null
    }
}