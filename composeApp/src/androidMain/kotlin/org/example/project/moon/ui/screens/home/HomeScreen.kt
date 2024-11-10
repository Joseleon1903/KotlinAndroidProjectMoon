package org.example.project.moon.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.util.DebugLogger
import coil3.util.Logger
import kotlinandroidprojectmoon.composeapp.generated.resources.Res
import kotlinandroidprojectmoon.composeapp.generated.resources.app_name
import org.example.project.moon.dto.Movie
import org.example.project.moon.dto.movies
import org.example.project.moon.ui.screens.Screen
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    Screen {

        val customScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(Res.string.app_name)) },
                    scrollBehavior = customScrollBehavior
                )
            },
            modifier = Modifier.nestedScroll(customScrollBehavior.nestedScrollConnection)
        ) { innerPadding ->
            // Contenido principal de la pantalla
            // para renderizar listado de pelicula
            LazyVerticalGrid(
                columns = GridCells.Adaptive(120.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)) {

                items( movies, key = {it.id}){
                    DebugLogger().log(
                        tag = "info",
                        level = Logger.Level.Info,
                        message = "innerPadding:$innerPadding",
                        throwable = null
                    )
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