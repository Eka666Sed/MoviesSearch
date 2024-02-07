package ru.yandex.practicum.moviessearch.domain.db

import kotlinx.coroutines.flow.Flow
import ru.yandex.practicum.moviessearch.domain.models.Movie

interface HistoryRepository {
    fun historyMovies(): Flow<List<Movie>>
}