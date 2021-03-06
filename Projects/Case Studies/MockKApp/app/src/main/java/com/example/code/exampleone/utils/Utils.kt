package com.example.code.exampleone.utils

import androidx.lifecycle.ViewModel

fun ViewModel.logEvent(event: String, attributes: Map<String,String> = emptyMap()) {
  val viewModelAttribute = "Logging View Model" to this::class.java.simpleName
  SpacingAnalytics().logEvent(event, attributes + viewModelAttribute)
}
