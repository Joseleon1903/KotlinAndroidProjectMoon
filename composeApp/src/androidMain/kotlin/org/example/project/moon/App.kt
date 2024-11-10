package org.example.project.moon

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import org.example.project.moon.ui.screens.detail.DetailScreen
import org.example.project.moon.ui.screens.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    // for load image
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context).
        crossfade(true).
        logger(DebugLogger()).build()
    }

    //HomeScreen()

    DetailScreen()
}
