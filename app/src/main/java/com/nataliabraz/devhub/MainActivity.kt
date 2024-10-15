package com.nataliabraz.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nataliabraz.devhub.ui.theme.DevHubTheme
import com.nataliabraz.devhub.ui.components.Profile
import com.nataliabraz.devhub.ui.screens.LoginScreen
import com.nataliabraz.devhub.ui.screens.ProfileScreen
import com.nataliabraz.devhub.ui.state.ProfileUIState
import com.nataliabraz.devhub.webclient.GithubWebClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "LoginScreen"
                    ) {
                        composable("LoginScreen") {
                            LoginScreen(navController)
                        }
                        composable(
                            route = "ProfileScreen/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            backStackEntry.arguments?.getString("id")?.let {
                                ProfileScreen(
                                    id = it,
                                    GithubWebClient()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DevHubTheme {
        Profile(
            user = ProfileUIState(
                name = "Foo",
                bio = "Foo bio",
                user = "foo",
                image = ""
            )
        )
    }
}