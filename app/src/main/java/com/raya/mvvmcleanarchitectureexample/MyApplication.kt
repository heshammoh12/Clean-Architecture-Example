package com.raya.mvvmcleanarchitectureexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.facebook.stetho.Stetho


@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}