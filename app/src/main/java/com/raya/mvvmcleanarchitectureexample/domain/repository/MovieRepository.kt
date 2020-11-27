package com.raya.mvvmcleanarchitectureexample.domain.repository

import com.raya.mvvmcleanarchitectureexample.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}