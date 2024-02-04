package ru.yandex.practicum.moviessearch.domain.api

import kotlinx.coroutines.flow.Flow
import ru.yandex.practicum.moviessearch.domain.models.Movie
import ru.yandex.practicum.moviessearch.domain.models.MovieCast
import ru.yandex.practicum.moviessearch.domain.models.MovieDetails
import ru.yandex.practicum.moviessearch.util.Resource

interface MoviesRepository {
    fun searchMovies(expression: String): Flow<Resource<List<Movie>>>
    fun getMovieDetails(movieId: String): Flow<Resource<MovieDetails>>
    fun getMovieCast(movieId: String): Flow<Resource<MovieCast>>
}
