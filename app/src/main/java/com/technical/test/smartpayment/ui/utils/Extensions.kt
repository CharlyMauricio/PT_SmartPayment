package com.technical.test.smartpayment.ui.utils

import androidx.compose.foundation.lazy.LazyListState
fun String.getInitials(): String = this.split(' ')
    .mapNotNull { it.firstOrNull()?.toString() }
    .reduce { acc, s -> acc + s }

fun String.isLetters(): Boolean {
    return this.replace(" ", "").all { it.isLetter() }
}

fun String.firstCharUpperCase() = replaceFirstChar(Char::titlecase)

fun String.getIdPlanet(): String {
    return this.replace("[^0-9]".toRegex(), "")
}

fun LazyListState.reachedBottom(buffer: Int = 1): Boolean {
    val lastVisibleItem = this.layoutInfo.visibleItemsInfo.lastOrNull()
    return lastVisibleItem?.index != 0 && lastVisibleItem?.index == this.layoutInfo.totalItemsCount - buffer
}