package com.yogadarma.watchmovie.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yogadarma.watchmovie.R
import com.yogadarma.watchmovie.ui.theme.WatchMovieTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier, inputCallback: (String) -> Unit = {}) {
    var input by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.light_gray),
            disabledBorderColor = Color.Transparent,
            focusedBorderColor = colorResource(id = R.color.red),
            unfocusedBorderColor = Color.Transparent,
        ),
        value = input,
        onValueChange = {
            input = it
            inputCallback(it)
        },
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
        SearchBar()
    }
}