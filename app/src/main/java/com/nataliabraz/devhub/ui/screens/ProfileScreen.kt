package com.nataliabraz.devhub.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.nataliabraz.devhub.ui.components.Profile
import com.nataliabraz.devhub.webclient.GithubWebClient

@Composable
fun ProfileScreen(
    id: String,
    webClient: GithubWebClient
) {
    val uiState = webClient.uiState

    LaunchedEffect(null) {
        webClient.getUserProfile(id)
    }

    Profile(uiState)
}
