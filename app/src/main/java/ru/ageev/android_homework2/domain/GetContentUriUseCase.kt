package ru.ageev.android_homework2.domain

import android.content.ContentResolver
import android.net.Uri
import javax.inject.Inject

class GetContentUriUseCase @Inject constructor(
    private val contentResolver: ContentResolver
) {
    operator fun invoke(uri: Uri?): ByteArray? {
        if (uri == null) {
            return null
        }

        return contentResolver.openInputStream(uri).use {
            it?.readBytes()
        }
    }
}