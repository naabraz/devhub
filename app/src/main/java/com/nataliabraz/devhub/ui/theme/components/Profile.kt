package com.nataliabraz.devhub.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(name: String, userId: String, bio: String) {
    Column(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            name,
            fontSize = 32.sp
        )
        Text(
            userId,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            bio,
            Modifier
                .padding(
                    start = 8.dp,
                    bottom = 8.dp,
                    end = 8.dp
                )
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}