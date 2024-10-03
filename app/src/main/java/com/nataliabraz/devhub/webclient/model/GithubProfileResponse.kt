package com.nataliabraz.devhub.webclient.model

import com.squareup.moshi.Json

data class GithubProfileResponse(
    val login: String,
    @Json(name = "avatar_url")
    val avatar: String,
    val name: String,
    val bio: String
)