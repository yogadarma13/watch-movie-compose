package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier, query: String, onValueChange: (String) -> Unit = {}) {
    OutlinedTextField(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .testTag("SearchBar"),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = MaterialTheme.colors.secondary,
            disabledBorderColor = Color.Transparent,
            focusedBorderColor = colorResource(id = R.color.red),
            unfocusedBorderColor = Color.Transparent,
        ),
        value = query,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_search))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_description)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    WatchMovieTheme {
        SearchBar(query = "")
    }
}