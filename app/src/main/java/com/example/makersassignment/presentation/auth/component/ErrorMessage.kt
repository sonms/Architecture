package com.example.makersassignment.presentation.auth.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ErrorMessage(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = Color.Red,
        modifier = modifier,
        textAlign = TextAlign.Start,
    )
}