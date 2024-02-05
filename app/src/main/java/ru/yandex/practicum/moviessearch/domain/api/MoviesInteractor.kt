package ru.yandex.practicum.moviessearch.domain.api

import kotlinx.coroutines.flow.Flow
import ru.yandex.practicum.moviessearch.domain.models.Movie
import ru.yandex.practicum.moviessearch.domain.models.MovieCast
import ru.yandex.practicum.moviessearch.domain.models.MovieDetails

interface MoviesInteractor {
    fun searchMovies(expression: String): Flow<Pair<List<Movie>?, String?>>
    fun getMoviesDetails(movieId: String): Flow<Pair<MovieDetails?, String?>>
    fun getMovieCast(movieId: String): Flow<Pair<MovieCast?, String?>>
}
