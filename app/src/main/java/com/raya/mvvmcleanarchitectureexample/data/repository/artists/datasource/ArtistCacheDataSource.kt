package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource

import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)

}