package ru.yandex.practicum.moviessearch.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.yandex.practicum.moviessearch.domain.db.HistoryInteractor
import ru.yandex.practicum.moviessearch.domain.db.HistoryRepository
import ru.yandex.practicum.moviessearch.domain.models.Movie

class HistoryInteractorImpl(private val historyRepository: HistoryRepository) : HistoryInteractor {
    override fun historyMovies(): Flow<List<Movie>> {
        return historyRepository.historyMovies()
    }
}