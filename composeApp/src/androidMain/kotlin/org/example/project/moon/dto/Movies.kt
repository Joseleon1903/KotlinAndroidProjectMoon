package org.example.project.moon.dto

data class Movie (
    val id : Int,
    val title:String,
    val poster:String
)

val movies =( 1 .. 100 ).map {
    Movie(  id = it, title = "Movie $it", poster = "https://loremflickr.com/200/200?random=$it")
}