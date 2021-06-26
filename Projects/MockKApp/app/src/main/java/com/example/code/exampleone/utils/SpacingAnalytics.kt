package com.example.code.exampleone.utils

import android.util.Log

class SpacingAnalytics {
  fun logEvent(event: String, attributes: Map<String, String> = emptyMap()) {
    println("Actual method is being run in test")
    val newAttribtues = attributes.toMutableMap()
    newAttribtues["client_type"] = "Android"
    newAttribtues["version"] = "1"
    ThirdPartyAnalyticsProvider.logEvent(event, newAttribtues)
  }
}