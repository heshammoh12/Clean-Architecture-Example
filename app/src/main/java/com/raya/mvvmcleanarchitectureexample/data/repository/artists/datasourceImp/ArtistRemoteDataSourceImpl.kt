package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp

import com.raya.mvvmcleanarchitectureexample.data.api.TMDBApiService
import com.raya.mvvmcleanarchitectureexample.data.model.artist.ArtistList
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBApiService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}

