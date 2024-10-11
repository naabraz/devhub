package com.nataliabraz.devhub.webclient.model

import com.nataliabraz.devhub.ui.state.RepositoryUIState

data class GithubRepositoriesResponse(
    val name: String = "",
    val description: String? = ""
)

fun GithubRepositoriesResponse.toGithubRepository() = RepositoryUIState(
    name = name,
    description = description ?: ""
)