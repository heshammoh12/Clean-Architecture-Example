package com.raya.mvvmcleanarchitectureexample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist
import com.raya.mvvmcleanarchitectureexample.data.model.movie.Movie
import com.raya.mvvmcleanarchitectureexample.data.model.tvshow.TvShow


@Database (entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false)
abstract class AppDataBase():RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowsDao
    abstract fun artistDao(): ArtistDao
}