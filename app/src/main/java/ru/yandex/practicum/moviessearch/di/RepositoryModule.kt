package ru.yandex.practicum.moviessearch.di

import org.koin.dsl.module
import ru.yandex.practicum.moviessearch.data.HistoryRepositoryImpl
import ru.yandex.practicum.moviessearch.data.MoviesRepositoryImpl
import ru.yandex.practicum.moviessearch.data.NamesRepositoryImpl
import ru.yandex.practicum.moviessearch.data.converters.MovieCastConverter
import ru.yandex.practicum.moviessearch.data.converters.MovieDbConvertor
import ru.yandex.practicum.moviessearch.domain.api.MoviesRepository
import ru.yandex.practicum.moviessearch.domain.api.NamesRepository
import ru.yandex.practicum.moviessearch.domain.db.HistoryRepository

val repositoryModule = module {

    factory { MovieCastConverter() }
    factory { MovieDbConvertor() }

    single<MoviesRepository> {
        MoviesRepositoryImpl(get(), get(), get(), get())
    }

    single<NamesRepository>{
        NamesRepositoryImpl(get())
    }

    single<HistoryRepository> {
        HistoryRepositoryImpl(get(), get())
    }
}
