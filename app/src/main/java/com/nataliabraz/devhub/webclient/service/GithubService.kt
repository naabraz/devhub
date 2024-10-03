package com.nataliabraz.devhub.webclient.service

import com.nataliabraz.devhub.webclient.model.GithubProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{user}")
    suspend fun getProfile(@Path("user") id: String): GithubProfileResponse
}