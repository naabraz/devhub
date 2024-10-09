package com.nataliabraz.devhub.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nataliabraz.devhub.ui.state.ProfileUIState

@Composable
fun Profile(user: ProfileUIState) {
    Column {
        val boxHeight = remember {
            150.dp
        }
        val imageHeight = remember {
            boxHeight
        }

        ProfileHeader(user.image, boxHeight, imageHeight)

        Spacer(Modifier.height(imageHeight / 2))

        ProfileInfo(user.name, user.user, user.bio)
    }
}