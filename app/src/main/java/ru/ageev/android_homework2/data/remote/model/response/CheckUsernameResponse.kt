package ru.ageev.android_homework2.data.remote.model.response

enum class CheckUsernameEnumResponse {
    TooShort,
    TooLong,
    InvalidCharacters,
    Taken,
    Free
}