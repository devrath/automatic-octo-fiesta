package com.example.code.exampleone.screens.images

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.code.R
import com.example.code.exampleone.models.ApodImage

class ImagesAdapter : RecyclerView.Adapter<ImagesViewHolder>() {
  var items: List<ApodImage> = emptyList()
    set(value) {
      field = value
      notifyDataSetChanged()
    }
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_images_item, parent, false)
    return ImagesViewHolder(view)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
    val item = items[position]
    holder.bind(item)
  }
}