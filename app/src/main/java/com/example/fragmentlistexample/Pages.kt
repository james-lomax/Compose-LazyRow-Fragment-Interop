package com.example.fragmentlistexample

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun Pages(modifier: Modifier, content: @Composable (String) -> Unit) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val cardWidth = screenWidth - 48.dp

    val state = rememberLazyListState()

    LazyRow(
        modifier = modifier.fillMaxSize(),
        state = state,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
    ) {
        items((0..10).toList()) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(cardWidth)
                    .padding(16.dp)
                    .background(color = Color.Yellow)
            ) {
                Text(text = "Page $it")
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                ) {
                    content("Page $it")
                }
            }
        }
    }
}
