package ru.yandex.practicum.moviessearch.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.yandex.practicum.moviessearch.data.converters.MovieCastConverter
import ru.yandex.practicum.moviessearch.data.dto.MovieCastRequest
import ru.yandex.practicum.moviessearch.data.dto.MovieCastResponse
import ru.yandex.practicum.moviessearch.data.dto.MovieDetailsRequest
import ru.yandex.practicum.moviessearch.data.dto.MoviesSearchRequest
import ru.yandex.practicum.moviessearch.data.dto.MoviesSearchResponse
import ru.yandex.practicum.moviessearch.domain.api.MoviesRepository
import ru.yandex.practicum.moviessearch.domain.models.Movie
import ru.yandex.practicum.moviessearch.domain.models.MovieCast
import ru.yandex.practicum.moviessearch.domain.models.MovieDetails
import ru.yandex.practicum.moviessearch.util.Resource

class MoviesRepositoryImpl(
    private val networkClient: NetworkClient,
    private val movieCastConverter: MovieCastConverter,
) : MoviesRepository {

    override fun searchMovies(expression: String): Flow<Resource<List<Movie>>> {
        return flow {
            val response = networkClient.doRequest(MoviesSearchRequest(expression))
            when (response.resultCode) {
                -1 -> emit(Resource.Error("Проверьте подключение к интернету"))
                200 -> {
                    emit(Resource.Success((response as MoviesSearchResponse).results.map {
                        Movie(
                            it.id,
                            it.resultType,
                            it.image,
                            it.title,
                            it.description
                        )
                    }))
                }

                else -> emit(Resource.Error("Ошибка сервера"))
            }
        }
    }

    override fun getMovieDetails(movieId: String): Flow<Resource<MovieDetails>> = flow {
        val response = networkClient.doRequest(MovieDetailsRequest(movieId))
        when (response.resultCode) {
            -1 -> emit(Resource.Error("Проверьте подключение к интернету"))
            200 -> {
               // emit(Resource.Success((response as MovieDetailsResponse)
            }
            else -> emit(Resource.Error("Ошибка сервера"))
        }
    }

    override fun getMovieCast(movieId: String): Flow<Resource<MovieCast>> = flow {
        val response = networkClient.doRequest(MovieCastRequest(movieId))
        when (response.resultCode) {
            -1 -> emit(Resource.Error("Проверьте подключение к интернету"))
            200 -> {
                emit(Resource.Success(
                    data = movieCastConverter.convert(response as MovieCastResponse)))
            }
            else -> emit(Resource.Error("Ошибка сервера"))
        }
    }
}



