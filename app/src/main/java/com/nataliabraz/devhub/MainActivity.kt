package com.nataliabraz.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nataliabraz.devhub.ui.theme.DevHubTheme

private const val personNameMock = "Natalia"
private const val personUserIdMock = "naabraz"
private const val personBioMock = "My bio"

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
        val boxHeight = remember {
            150.dp
        }
        val imageHeight = remember {
            boxHeight
        }

        Header(boxHeight, imageHeight)

        Spacer(Modifier.height(imageHeight / 2))

        Profile(name, userId, bio)
    }
}

@Composable
fun Header(boxHeight: Dp, imageHeight: Dp) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(
                Color(0xFF2d333b),
                shape = RoundedCornerShape(
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                )
            )
            .height(boxHeight)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_avatar),
            contentDescription = stringResource(id = R.string.user_image_content_description),
            Modifier
                .offset(y = imageHeight / 2)
                .size(imageHeight)
                .align(Alignment.BottomCenter)
                .clip(CircleShape),
        )
    }
}

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