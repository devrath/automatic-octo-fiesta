package com.example.code.core.platform

import android.content.Context



class FakeNetworkHandler constructor(private val context: Context,
                                     private val isNetAvailable:Boolean) : NetworkHandler(context){
    override fun isNetworkAvailable(): Boolean {
        return isNetAvailable
    }
}