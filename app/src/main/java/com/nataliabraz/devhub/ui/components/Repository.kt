package com.nataliabraz.devhub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.nataliabraz.devhub.ui.state.RepositoryUIState

@Composable
fun Repository(repo: RepositoryUIState) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Text(
                repo.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2d333b))
                    .padding(8.dp),
                fontSize = 24.sp,
                color = Color.White
            )
            if (repo.description.isNotBlank()) {
                Text(
                    repo.description,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepositoryPreview() {
    Repository(
        repo = RepositoryUIState(
            name = "alexfelipe",
            description = "my personal information"
        )
    )
}