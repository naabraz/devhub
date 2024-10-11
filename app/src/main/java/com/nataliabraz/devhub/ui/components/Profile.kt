package com.nataliabraz.devhub.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nataliabraz.devhub.ui.state.ProfileUIState

@Composable
fun Profile(user: ProfileUIState) {
    LazyColumn {
        item {
            ProfileHeader(user.image, 150.dp, 150.dp)

            Spacer(Modifier.height(150.dp / 2))

            ProfileInfo(user.name, user.user, user.bio)
        }
        item {
            if (user.repositories.isNotEmpty()) {
                Text(
                    text = "Repositories", Modifier.padding(8.dp),
                    fontSize = 24.sp
                )
            }
        }
        items(user.repositories) { repo ->
            Repository(repo = repo)
        }
    }
}