package com.nataliabraz.devhub.webclient.service

import com.nataliabraz.devhub.webclient.model.GithubProfileResponse
import com.nataliabraz.devhub.webclient.model.GithubRepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{user}")
    suspend fun getProfile(@Path("user") id: String): GithubProfileResponse

    @GET("/users/{user}/repos")
    suspend fun getRepositories(@Path("user") id: String): List<GithubRepositoriesResponse>
}