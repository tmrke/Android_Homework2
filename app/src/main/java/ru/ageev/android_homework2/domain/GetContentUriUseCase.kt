package ru.ageev.android_homework2.domain

import android.content.ContentResolver
import android.net.Uri
import javax.inject.Inject

class GetContentUriUseCase @Inject constructor(
    private val contentResolver: ContentResolver
) {

    //переопределяем оператор invoke / можно написать метод execute как в других юзкейсах
    operator fun invoke(uri: Uri): ByteArray? {
        return contentResolver.openInputStream(uri).use {
            it?.readBytes()
        }
    }
}