package com.nataliabraz.devhub.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nataliabraz.devhub.ui.theme.components.Header
import com.nataliabraz.devhub.ui.theme.components.Profile
import com.nataliabraz.devhub.webclient.GithubWebClient

@Composable
fun PersonInfo(id: String) {
    val webClient = GithubWebClient()
    val user by webClient.getUserProfile(id).collectAsState(initial = null)

    user?.let {
        Column {
            val boxHeight = remember {
                150.dp
            }
            val imageHeight = remember {
                boxHeight
            }

            Header(it.avatar, boxHeight, imageHeight)

            Spacer(Modifier.height(imageHeight / 2))

            Profile(it.name, it.login, it.bio)
        }
    }
}
