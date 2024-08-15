package com.technical.test.smartpayment.ui.utils.composable

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackNavigationIcon(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = rememberVectorPainter(image = Icons.AutoMirrored.Sharp.ArrowBack),
            contentDescription = null
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun BackNavigationIconPreview() {
    BackNavigationIcon(onClick = {})
}