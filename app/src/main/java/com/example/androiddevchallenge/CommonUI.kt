package com.example.androiddevchallenge

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.screenPadding
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.primary,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier
            .padding(start = screenPadding, end = screenPadding)
            .height(72.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        onClick = onClick,
        content = content,

        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    )
}
