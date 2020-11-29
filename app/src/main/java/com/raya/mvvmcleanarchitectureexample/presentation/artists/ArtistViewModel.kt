package com.raya.mvvmcleanarchitectureexample.presentation.artists

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.raya.mvvmcleanarchitectureexample.domain.usecase.GetArtistsUseCase
import com.raya.mvvmcleanarchitectureexample.domain.usecase.UpdateArtistsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Singleton


class ArtistViewModel @ViewModelInject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {


    fun getArtistsTest(){
        viewModelScope.launch{
            val artists = updateArtistsUseCase.execute()
        }
    }

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val updatedArtists = updateArtistsUseCase.execute()
        emit(updatedArtists)
    }
/*   fun updateArtists(){

   }*/
}