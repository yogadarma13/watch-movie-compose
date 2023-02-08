package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DetailActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String,
    onClickCallback: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .background(shape = CircleShape, color = MaterialTheme.colors.secondaryVariant)
            .size(40.dp),
        onClick = onClickCallback
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}
