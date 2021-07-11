package com.example.code.exampleone.screens.images

import com.example.code.exampleone.models.ApodImage
import com.example.code.exampleone.network.SpacingOutApi
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

/**
 * This class uses coroutines to fetch a list of images from the API
 * We can consider this as the service class in our case
 */
class ImageListProvider(private val api: SpacingOutApi) {
  // Requests 30 images from the API
  private val numImages = 30
  suspend fun buildImageList(): List<ApodImage> = coroutineScope {

    val today = LocalDate.now()

    val deferredImages = mutableListOf<Deferred<ApodImage>>()

    /*for (i in 0 until numImages) {
      val day = today.minusDays(i.toLong())
      val image = async(Dispatchers.IO) {
        api.getImage(day.format(DateTimeFormatter.ISO_DATE)).execute().body()!!
      }
      deferredImages.add(image)
    }*/
    for (i in 0 until numImages) {
      val day = today.minusDays(i.toLong())
      val image = async(Dispatchers.IO) {api.getImage(day.format(DateTimeFormatter.ISO_DATE))}
      deferredImages.add(image)
    }

    deferredImages.map { it.await() }
  }
}