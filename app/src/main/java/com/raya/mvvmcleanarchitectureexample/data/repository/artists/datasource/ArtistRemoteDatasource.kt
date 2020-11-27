package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource

import com.raya.mvvmcleanarchitectureexample.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<ArtistList>
}