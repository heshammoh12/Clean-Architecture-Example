package com.raya.mvvmcleanarchitectureexample.domain.usecase

import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist
import com.raya.mvvmcleanarchitectureexample.domain.repository.ArtistRepository
import javax.inject.Inject

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}