package com.nataliabraz.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nataliabraz.devhub.ui.theme.DevHubTheme

private const val personNameMock = "Natalia"
private const val personUserIdMock = "naabraz"
private const val personBioMock = "I like to build things with JavaScript, Node.js and React and " +
        "I'm also studying iOS with SwiftUI \uD83E\uDD13"

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
                    PersonInfo(
                        personNameMock,
                        personUserIdMock,
                        personBioMock
                    )
                }
            }
        }
    }
}

@Composable
fun PersonInfo(name: String, userId: String, bio: String) {
    Column {
        PersonImage()
        Text(name)
        Text(userId)
        Text(bio)
    }
}

@Composable
fun PersonImage() {
    Image(
        painter = painterResource(id = R.drawable.user_avatar),
        contentDescription = stringResource(id = R.string.user_image_content_description),
        modifier = Modifier.size(150.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DevHubTheme {
        PersonInfo(
            personNameMock,
            personUserIdMock,
            personBioMock
        )
    }
}