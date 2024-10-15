package com.nataliabraz.devhub.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    var userId by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "DevHub",
            Modifier.padding(8.dp),
            fontSize = 32.sp
        )
        TextField(
            value = userId,
            onValueChange = {
                userId = it
            },
            label = {
                Text("User")
            }
        )
        Button(
            onClick = { navController.navigate("ProfileScreen/${userId}") },
            enabled = userId.isNotBlank() && userId.isNotEmpty()
        ) {
            Text("Enter")
        }
    }
}