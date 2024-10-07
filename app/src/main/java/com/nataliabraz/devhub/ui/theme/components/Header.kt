package com.nataliabraz.devhub.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nataliabraz.devhub.R

@Composable
fun Header(avatarUrl: String, boxHeight: Dp, imageHeight: Dp) {
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
        AsyncImage(
            model = avatarUrl,
            contentDescription = stringResource(id = R.string.user_image_content_description),
            Modifier
                .offset(y = imageHeight / 2)
                .size(imageHeight)
                .align(Alignment.BottomCenter)
                .clip(CircleShape),
        )
    }
}