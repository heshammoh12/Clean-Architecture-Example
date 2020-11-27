package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp

import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl :
    ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
       artistList.clear()
       artistList = ArrayList(artists)
    }
}