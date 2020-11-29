package com.raya.mvvmcleanarchitectureexample.presentation.artists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.raya.mvvmcleanarchitectureexample.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArtistsMenu : Fragment() {

    private val viewModel : ArtistViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.getArtistsTest()
        return inflater.inflate(R.layout.fragment_artists_menu, container, false)
    }

}