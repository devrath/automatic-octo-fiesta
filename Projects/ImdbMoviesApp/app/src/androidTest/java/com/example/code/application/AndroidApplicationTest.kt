package com.example.code.application

class AndroidApplicationTest : AndroidApplication() {

  var url = "http://127.0.0.1:8080"

  override fun getBaseUrl(): String {
    return url
  }
}