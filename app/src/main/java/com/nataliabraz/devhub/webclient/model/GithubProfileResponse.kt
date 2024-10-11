package com.nataliabraz.devhub.webclient.model

import com.nataliabraz.devhub.ui.state.ProfileUIState
import com.squareup.moshi.Json

data class GithubProfileResponse(
    val login: String,
    @Json(name = "avatar_url")
    val avatar: String,
    val name: String,
    val bio: String
)

fun GithubProfileResponse.toProfileUIState() = ProfileUIState(
    user = login,
    image = avatar,
    name = name,
    bio = bio
)