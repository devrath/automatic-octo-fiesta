package com.example.code.exampleone.images

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code.exampleone.SpacingAnalytics
import com.example.code.exampleone.models.ApodImage
import kotlinx.coroutines.launch

class ImagesViewModel(
  private val imageListProvider: ImageListProvider,
  private val analytics: SpacingAnalytics
)
  : ViewModel() {

  val imageLiveData = MutableLiveData<List<ApodImage>>()
  val errorLiveData = MutableLiveData<String>()

  init {
    viewModelScope.launch {
      try {
        analytics.logEvent("Fetching images")
        val items = imageListProvider.buildImageList().filter { it.media_type == "image" }
        imageLiveData.value = items
      } catch (exception: Exception) {
        errorLiveData.value = exception.message
      }
    }
  }
}