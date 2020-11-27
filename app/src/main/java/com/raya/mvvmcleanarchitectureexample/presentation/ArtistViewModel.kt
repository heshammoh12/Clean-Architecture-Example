package com.raya.mvvmcleanarchitectureexample.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.raya.mvvmcleanarchitectureexample.domain.usecase.GetArtistsUseCase
import com.raya.mvvmcleanarchitectureexample.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val updatedArtists = updateArtistsUseCase.execute()
        emit(updatedArtists)
    }
}