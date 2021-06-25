package com.example.code.exampleone

class SpacingAnalytics {
  fun logEvent(event: String, attributes: Map<String, String> = emptyMap()) {
    val newAttribtues = attributes.toMutableMap()
    newAttribtues["client_type"] = "Android"
    newAttribtues["version"] = "1"
    ThirdPartyAnalyticsProvider.logEvent(event, newAttribtues)
  }
}