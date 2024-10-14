package com.nataliabraz.devhub.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.nataliabraz.devhub.ui.components.Profile
import com.nataliabraz.devhub.webclient.GithubWebClient

@Composable
fun ProfileScreen(
    id: String,
    webClient: GithubWebClient
) {
    Log.i("ProfileScreen", "ProfileScreen: $id")
    val uiState = webClient.uiState

    LaunchedEffect(null) {
        webClient.getUserProfile(id)
    }

    Log.i("ProfileScreen", "ProfileScreen: $uiState")

    Profile(uiState)
}
