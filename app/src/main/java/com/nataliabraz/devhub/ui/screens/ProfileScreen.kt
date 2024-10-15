package com.nataliabraz.devhub.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.nataliabraz.devhub.ui.components.Profile
import com.nataliabraz.devhub.webclient.GithubWebClient

@Composable
fun ProfileScreen(
    id: String,
    webClient: GithubWebClient
) {
    val uiState by remember {
        derivedStateOf {
            webClient.uiState
        }
    }

    LaunchedEffect(null) {
        webClient.getUserProfile(id)
    }

    Profile(uiState)
}
