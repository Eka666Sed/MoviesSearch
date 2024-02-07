package ru.yandex.practicum.moviessearch.data.converters

import ru.yandex.practicum.moviessearch.data.db.entity.MovieEntity
import ru.yandex.practicum.moviessearch.data.dto.MovieDto
import ru.yandex.practicum.moviessearch.domain.models.Movie

class MovieDbConvertor {
    fun map(movie: MovieDto): MovieEntity{
        return MovieEntity(movie.id, movie.resultType, movie.image,
            movie.title, movie.description)
    }

    fun map(movie: MovieEntity): Movie{
        return Movie(movie.id,movie.resultType, movie.image,
            movie.title, movie.description)
    }
}