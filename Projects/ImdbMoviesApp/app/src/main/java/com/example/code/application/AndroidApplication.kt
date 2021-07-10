package com.example.code.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

object AppConstants {
    const val BASE_URL = "https://raw.githubusercontent.com/devrath/Sample-Data/master/Android-CleanArchitecture-Kotlin/"
}

@HiltAndroidApp
open class AndroidApplication : Application(){
    open fun getBaseUrl() = AppConstants.BASE_URL
}