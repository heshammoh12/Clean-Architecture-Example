package com.raya.mvvmcleanarchitectureexample.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.raya.mvvmcleanarchitectureexample.R
import com.raya.mvvmcleanarchitectureexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // TODO: 11/27/2020 to be implemnted later
        /*binding.movieButton.setOnClickListener {
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }*/

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }


    }
}