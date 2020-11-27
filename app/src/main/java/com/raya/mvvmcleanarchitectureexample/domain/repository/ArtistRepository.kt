package com.raya.mvvmcleanarchitectureexample.domain.repository

import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist


interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}