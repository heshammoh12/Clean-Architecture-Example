package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource

import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist

interface ArtistLocalDataSource {
  suspend fun getArtistsFromDB():List<Artist>
  suspend fun saveArtistsToDB(artists:List<Artist>)
  suspend fun clearAll()
}