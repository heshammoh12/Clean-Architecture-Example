package com.raya.mvvmcleanarchitectureexample.domain.usecase

import com.raya.mvvmcleanarchitectureexample.data.model.movie.Movie
import com.raya.mvvmcleanarchitectureexample.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.getMovies()
}