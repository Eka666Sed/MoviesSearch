package ru.yandex.practicum.moviessearch.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.yandex.practicum.moviessearch.domain.api.MoviesInteractor
import ru.yandex.practicum.moviessearch.domain.api.MoviesRepository
import ru.yandex.practicum.moviessearch.domain.models.Movie
import ru.yandex.practicum.moviessearch.domain.models.MovieCast
import ru.yandex.practicum.moviessearch.domain.models.MovieDetails
import ru.yandex.practicum.moviessearch.util.Resource

class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {

    override fun searchMovies(expression: String): Flow<Pair<List<Movie>?, String?>> {
        return repository.searchMovies(expression).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(null, result.message)
                }
            }
        }
    }

    override fun getMoviesDetails(movieId: String): Flow<Pair<MovieDetails?, String?>> {
        return repository.getMovieDetails(movieId).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(null, result.message)
                }
            }
        }
    }

    override fun getMovieCast(movieId: String): Flow<Pair<MovieCast?, String?>> {
        return repository.getMovieCast(movieId).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(null, result.message)
                }
            }
        }
    }
}
//    override fun getMovieCast(movieId: String, consumer: MoviesInteractor.MovieCastConsumer) {
//        executor.execute {
//            when(val resource = repository.getMovieCast(movieId)) {
//                is Resource.Success -> { consumer.consume(resource.data, null) }
//                is Resource.Error -> { consumer.consume(resource.data, resource.message) }
//            }
//        }
//    }

//    override fun getMoviesDetails(movieId: String, consumer: MoviesInteractor.MovieDetailsConsumer) {
//        executor.execute {
//            when(val resource = repository.getMovieDetails(movieId)) {
//                is Resource.Success -> { consumer.consume(resource.data, null) }
//                is Resource.Error -> { consumer.consume(resource.data, resource.message) }
//            }
//        }
//    }



