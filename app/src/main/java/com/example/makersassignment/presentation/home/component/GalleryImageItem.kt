package com.example.makersassignment.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import com.example.makersassignment.R

@Composable
fun GalleryImageItem(
    imageUrl : String,
    author : String,
    modifier : Modifier = Modifier
) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .crossfade(true)
        .size(300, 300)
        .error(R.drawable.ic_image_not_supported_24)
        .precision(Precision.INEXACT)
        .build()

    Card (
        modifier = modifier
            .padding(4.dp)
            .aspectRatio(1f)
    ) {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            AsyncImage(
                model = imageRequest,
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.home_gallery_image_content_description),
                modifier = Modifier.fillMaxSize()
            )

            Text(
                text = author,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primary
                    )
                    .padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun GalleryImageItemPreview() {
    GalleryImageItem(
        imageUrl = "",
        author = "author"
    )
}