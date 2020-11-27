package com.raya.mvvmcleanarchitectureexample.data.api

import com.raya.mvvmcleanarchitectureexample.data.model.artist.ArtistList
import com.raya.mvvmcleanarchitectureexample.data.model.movie.MovieList
import com.raya.mvvmcleanarchitectureexample.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>

}