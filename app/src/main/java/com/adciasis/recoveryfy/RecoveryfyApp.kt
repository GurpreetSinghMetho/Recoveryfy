package com.adciasis.recoveryfy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RecoveryfyApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}