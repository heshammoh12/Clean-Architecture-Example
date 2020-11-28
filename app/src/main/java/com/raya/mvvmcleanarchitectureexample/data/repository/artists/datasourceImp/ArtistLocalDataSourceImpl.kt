package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp

import com.raya.mvvmcleanarchitectureexample.data.db.ArtistDao
import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtistLocalDataSourceImpl @Inject constructor(private val artistDao: ArtistDao):
    ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
       return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           artistDao.clearArtists()
       }
    }
}