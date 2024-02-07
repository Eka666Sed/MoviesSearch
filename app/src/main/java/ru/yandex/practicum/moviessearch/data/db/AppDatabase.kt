package ru.yandex.practicum.moviessearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.yandex.practicum.moviessearch.data.db.dao.MovieDao
import ru.yandex.practicum.moviessearch.data.db.entity.MovieEntity

@Database(version = 1, entities = [MovieEntity::class])
abstract class AppDatabase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
}