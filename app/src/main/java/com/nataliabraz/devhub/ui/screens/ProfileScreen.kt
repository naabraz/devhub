package com.nataliabraz.devhub.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.nataliabraz.devhub.ui.components.Profile
import com.nataliabraz.devhub.ui.state.ProfileUIState
import com.nataliabraz.devhub.webclient.GithubWebClient

@Composable
fun ProfileScreen(
    id: String,
    webClient: GithubWebClient
) {
    val user by webClient.getUserProfile(id).collectAsState(initial = null)
    user?.let {
        val userUIState = ProfileUIState(
            name = it.name,
            bio = it.bio,
            image = it.avatar,
            user = it.login
        )
       Profile(userUIState)
    }
}
