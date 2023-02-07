package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.R

@Composable
fun DetailActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String,
    onClickCallback: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .background(shape = CircleShape, color = colorResource(id = R.color.white_50))
            .size(40.dp),
        onClick = onClickCallback
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}
