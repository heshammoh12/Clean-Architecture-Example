package com.raya.mvvmcleanarchitectureexample.domain.usecase

import com.raya.mvvmcleanarchitectureexample.data.model.tvshow.TvShow
import com.raya.mvvmcleanarchitectureexample.domain.repository.TvShowRepository
import javax.inject.Inject

class UpdateTvShowsUseCase @Inject constructor(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}