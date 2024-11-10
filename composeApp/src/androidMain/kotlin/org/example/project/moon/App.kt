package org.example.project.moon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import org.example.project.moon.dto.Movie
import org.example.project.moon.dto.movies
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {

        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context).
            crossfade(true).
            logger(DebugLogger()).build()
        }

        //
      Surface( modifier = Modifier.fillMaxSize()) {
          // para renderizar listado de pelicula
          LazyVerticalGrid(
              columns = GridCells.Adaptive(120.dp),
              contentPadding = PaddingValues(4.dp),
              horizontalArrangement = Arrangement.spacedBy(4.dp),
              verticalArrangement = Arrangement.spacedBy(4.dp)) {

              items( movies, key = {it.id}){
                  MovieItem(movie = it)
              }
          }
      }
    }
}

@Composable
fun MovieItem(movie: Movie){
    Column {
//        Box(
//            modifier = Modifier.fillMaxSize().aspectRatio(2f/3)
//                .clip(MaterialTheme.shapes.small)
//                .background(MaterialTheme.colorScheme.primaryContainer)
//        )
        AsyncImage(
            model = movie.poster,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().aspectRatio(2f/3)
                .clip(MaterialTheme.shapes.small)
        )

        Text(
            text = movie.title,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier.padding(8.dp)
        )

    }


}