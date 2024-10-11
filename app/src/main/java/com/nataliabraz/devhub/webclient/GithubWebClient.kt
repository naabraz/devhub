package com.nataliabraz.devhub.webclient

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nataliabraz.devhub.ui.state.ProfileUIState
import com.nataliabraz.devhub.webclient.model.toGithubRepository
import com.nataliabraz.devhub.webclient.model.toProfileUIState
import com.nataliabraz.devhub.webclient.service.GithubService

class GithubWebClient {
    private val githubService: GithubService = RetrofitLauncher().githubService

    var uiState by mutableStateOf(ProfileUIState())
    private set

    suspend fun getUserProfile(id: String) {
        try {
            val profile = githubService.getProfile(id).toProfileUIState()
            val repositories = githubService.getRepositories(id).map { it.toGithubRepository() }
            uiState = profile.copy(repositories = repositories)
        } catch (e: Exception) {
            Log.e("GitHubWebClient", "findProfileBy: falha ao buscar usuário", e)
        }
    }
}