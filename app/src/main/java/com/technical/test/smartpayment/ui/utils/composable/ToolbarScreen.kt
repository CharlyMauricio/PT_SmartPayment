package com.technical.test.smartpayment.ui.utils.composable

import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ToolbarScreen(
    title: String,
    onClickBack: () -> Unit
) {
    TopAppBar(
        title = {
            TopBarNavigation(
                title,
                onClickBack = { onClickBack() }
            )
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}