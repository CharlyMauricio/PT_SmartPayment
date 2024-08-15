package com.technical.test.smartpayment.ui.utils.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBarNavigation(
    title: String,
    onClickBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackNavigationIcon(onClickBack)

        Text(title)

    }
}

@Composable
@Preview(showBackground = true)
private fun TopBarNavigationPreview() {
    TopBarNavigation(
        "Titulo de la navegacion",
        onClickBack = {}
    )
}