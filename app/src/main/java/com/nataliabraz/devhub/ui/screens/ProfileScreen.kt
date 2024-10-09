package com.nataliabraz.devhub.ui.screens

import android.util.Log
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
    val repositories by webClient.getUserRepositories(id).collectAsState(initial = null)

    repositories?.let {
        repositories?.forEach { repository ->
            Log.i("ProfileScreen", "ProfileScreen: ${repository.name}")
            Log.i("ProfileScreen", "ProfileScreen: ${repository.description}")
        }
    }

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
