package com.raya.mvvmcleanarchitectureexample.data.repository.artists

import android.util.Log
import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistCacheDataSource
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistLocalDataSource
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistRemoteDatasource
import com.raya.mvvmcleanarchitectureexample.domain.repository.ArtistRepository
import java.lang.Exception
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
       return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistsFromAPI()
        Log.i("ArtistRepositoryImpl", "newListOfArtist[0].name")
        Log.i("ArtistRepositoryImpl", newListOfArtist[0].name)
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
           artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList= getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList =artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }

}