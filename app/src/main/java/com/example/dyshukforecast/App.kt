package com.example.dyshukforecast

import android.app.Application
import com.google.android.libraries.places.api.Places

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Places.initialize(this, "AIzaSyCxedWHYRrqJJGEGHmwXT3iZnJZ446uRNM")
    }

}