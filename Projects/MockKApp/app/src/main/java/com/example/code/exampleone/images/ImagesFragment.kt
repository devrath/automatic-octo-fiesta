package com.example.code.exampleone.images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.code.R
import com.google.android.material.snackbar.Snackbar
import com.example.code.exampleone.SpacingAnalytics
import com.example.code.exampleone.createViewModel
import com.example.code.exampleone.network.SpacingOutApi
import kotlinx.android.synthetic.main.fragment_images.view.*

class ImagesFragment : Fragment() {

  private val viewModel by lazy {
    createViewModel { ImagesViewModel(ImageListProvider(SpacingOutApi.create()), SpacingAnalytics()) }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_images, container, false)
    val adapter = ImagesAdapter()
    view.list.layoutManager = LinearLayoutManager(container?.context)
    view.list.adapter = adapter
    viewModel.imageLiveData.observe(viewLifecycleOwner, Observer {
      adapter.items = it
    })
    viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
      Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show()
    })

    return view
  }
}