package com.enesk.rickmorty.ui

import android.app.Application
import androidx.viewbinding.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber(){
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}