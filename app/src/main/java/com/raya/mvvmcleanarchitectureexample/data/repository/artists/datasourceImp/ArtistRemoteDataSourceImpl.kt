package com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp

import com.raya.mvvmcleanarchitectureexample.BuildConfig
import com.raya.mvvmcleanarchitectureexample.data.api.TMDBApiService
import com.raya.mvvmcleanarchitectureexample.data.model.artist.ArtistList
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistRemoteDatasource
import retrofit2.Response
import javax.inject.Inject

class ArtistRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBApiService
): ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(BuildConfig.API_KEY)

}

