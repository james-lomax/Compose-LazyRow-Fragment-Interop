package com.example.fragmentlistexample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.fragmentlistexample.databinding.FragmentLayoutBinding

@Composable
fun LayoutFragmentWrapper(text: String) {
    key(text) {
        AndroidViewBinding(
            factory = FragmentLayoutBinding::inflate,
            modifier = Modifier.fillMaxSize().shadow(elevation = 20.dp)
        )
    }
}