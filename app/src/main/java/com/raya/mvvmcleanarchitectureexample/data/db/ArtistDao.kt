package com.raya.mvvmcleanarchitectureexample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raya.mvvmcleanarchitectureexample.data.model.artist.Artist
import com.raya.mvvmcleanarchitectureexample.data.model.artist.ArtistList

@Dao
interface ArtistDao {

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artistList: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun clearArtists()
}