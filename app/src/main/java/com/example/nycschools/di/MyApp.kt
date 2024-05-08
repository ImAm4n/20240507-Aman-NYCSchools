package com.example.nycschools.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * MyApp - The base class that contains the application-level dependency container.
 * */
@HiltAndroidApp
class MyApp : Application() {
}