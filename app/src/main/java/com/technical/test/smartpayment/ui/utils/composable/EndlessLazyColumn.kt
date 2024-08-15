package com.technical.test.smartpayment.ui.utils.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.technical.test.smartpayment.ui.utils.reachedBottom


@Composable
internal fun <T> EndlessLazyColumn(
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    items: List<T>,
    itemContent: @Composable (T) -> Unit,
    loadMore: () -> Unit
) {

    val reachedBottom: Boolean by remember { derivedStateOf { listState.reachedBottom() } }

    LaunchedEffect(reachedBottom) {
        if (reachedBottom) loadMore()
    }

    LazyColumn(modifier = modifier, state = listState) {
        items(
            items = items,
        ) { item ->
            itemContent(item)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun EndlessLazyColumnPreview() {
    EndlessLazyColumn(
        modifier = Modifier,
        items = listOf("Esta es una prueba", "donde se pintan los item mas facilmente"),
        itemContent = {
            Text(text = it)
        },
        loadMore = {}
    )
}