package com.raya.mvvmcleanarchitectureexample.di

import android.content.Context
import androidx.room.Room
import com.raya.mvvmcleanarchitectureexample.data.api.TMDBApiService
import com.raya.mvvmcleanarchitectureexample.data.db.AppDataBase
import com.raya.mvvmcleanarchitectureexample.data.db.ArtistDao
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.ArtistRepositoryImpl
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistCacheDataSource
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistLocalDataSource
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasource.ArtistRemoteDatasource
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp.ArtistCacheDataSourceImpl
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp.ArtistLocalDataSourceImpl
import com.raya.mvvmcleanarchitectureexample.data.repository.artists.datasourceImp.ArtistRemoteDataSourceImpl
import com.raya.mvvmcleanarchitectureexample.domain.repository.ArtistRepository
import com.raya.mvvmcleanarchitectureexample.domain.usecase.GetArtistsUseCase
import com.raya.mvvmcleanarchitectureexample.domain.usecase.UpdateArtistsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDatasource,artistLocalDataSource,artistCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbApiService: TMDBApiService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(tmdbApiService)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }


    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDataBase::class.java,
        "db"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideArtisDao(db: AppDataBase) = db.artistDao() // The reason we can implement a Dao for the database
}