package ru.ageev.android_homework2.data.mappers

import ru.ageev.android_homework2.data.model.ProfileCompact
import ru.ageev.android_homework2.data.remote.model.ApiProfileCompact
import javax.inject.Inject

class ProfileCompactMapper @Inject constructor() {
    fun toProfileCompact(apiProfileCompact: ApiProfileCompact) = ProfileCompact(
        id = apiProfileCompact.id,
        username = apiProfileCompact.username,
        displayName = apiProfileCompact.displayName,
        avatarUrl = apiProfileCompact.avatarUrl,
        subscribed = apiProfileCompact.subscribed,
    )
}