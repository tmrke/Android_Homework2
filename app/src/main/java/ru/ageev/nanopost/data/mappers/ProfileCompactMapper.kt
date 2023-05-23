package ru.ageev.nanopost.data.mappers

import ru.ageev.nanopost.data.model.ProfileCompact
import ru.ageev.nanopost.data.remote.model.ApiProfileCompact

class ProfileCompactMapper{
    fun toProfileCompact(apiProfileCompact: ApiProfileCompact) = ProfileCompact(
        id = apiProfileCompact.id,
        username = apiProfileCompact.username,
        displayName = apiProfileCompact.displayName,
        avatarUrl = apiProfileCompact.avatarUrl,
        subscribed = apiProfileCompact.subscribed,
    )
}