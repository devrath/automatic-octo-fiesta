package com.example.code.exampleone.screens.lookup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code.exampleone.utils.logEvent
import com.example.code.exampleone.network.SpacingOutApi
import kotlinx.coroutines.launch

class LookupViewModel : ViewModel() {

  val imageLiveData = MutableLiveData<String>()
  val showErrorLiveData = MutableLiveData<String>()

  private val api = SpacingOutApi.create()

  fun latLongInput(latitude: Float, longitude: Float) = viewModelScope.launch {
    try {
      val image = api.getEarthImagery(longitude, latitude)
      imageLiveData.value = image.url
      logEvent("image retrieved", mapOf("latitude" to latitude.toString(), "longitude" to longitude.toString()))
    } catch (e: Exception) {
      showErrorLiveData.value = e.message
    }
  }
}