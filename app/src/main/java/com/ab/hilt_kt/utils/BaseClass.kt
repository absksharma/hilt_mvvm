package com.ab.hilt_kt.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseClass : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}