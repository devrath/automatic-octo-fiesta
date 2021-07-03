package com.example.code

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.code.utils.OkHttpIdlingResourceRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class BaseTest {

    @get:Rule
    var rule = OkHttpIdlingResourceRule()

    val portNumber = 8080

    val mockWebServer = MockWebServer()

}