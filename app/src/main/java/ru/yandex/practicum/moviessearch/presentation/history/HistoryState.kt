package ru.yandex.practicum.moviessearch.presentation.history

import ru.yandex.practicum.moviessearch.domain.models.Movie

sealed interface HistoryState {
    object Loading : HistoryState

    data class Content(
        val movies: List<Movie>
    ) : HistoryState

    data class Empty(
        val message: String
    ) : HistoryState
}