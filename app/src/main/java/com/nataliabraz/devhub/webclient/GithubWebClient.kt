package com.nataliabraz.devhub.webclient

import com.nataliabraz.devhub.webclient.service.GithubService
import kotlinx.coroutines.flow.flow

class GithubWebClient {
    private val githubService: GithubService = RetrofitLauncher().githubService

    fun getUserProfile(id: String) = flow {
        emit(githubService.getProfile(id))
    }
}