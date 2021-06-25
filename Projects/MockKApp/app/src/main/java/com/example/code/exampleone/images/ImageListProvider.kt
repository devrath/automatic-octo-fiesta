package com.example.code.exampleone.images

import com.example.code.exampleone.models.ApodImage
import com.example.code.exampleone.network.SpacingOutApi
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class ImageListProvider(private val api: SpacingOutApi) {
  private val numImages = 30
  suspend fun buildImageList(): List<ApodImage> = coroutineScope {
    val today = LocalDate.now()
    val deferredImages = mutableListOf<Deferred<ApodImage>>()
    for (i in 0 until numImages) {
      val day = today.minusDays(i.toLong())
      val image = async(Dispatchers.IO) {
        api.getImage(day.format(DateTimeFormatter.ISO_DATE)).execute().body()!!
      }
      deferredImages.add(image)
    }

    deferredImages.map { it.await() }
  }
}