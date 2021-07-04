package com.example.code.base

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.code.utils.FileReader
import com.example.code.utils.OkHttpIdlingResourceRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
abstract class BaseTest {

    @get:Rule
    var rule = OkHttpIdlingResourceRule()

    val portNumber = 8080

    val mockWebServer = MockWebServer()

    @Before
    @Throws
    fun setup() {
        mockWebServer.start(portNumber)
    }

    @After
    @Throws
    fun teardown() {
        mockWebServer.shutdown()
    }


    fun successfulServerResponse(inputJsonPath : String) {
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(FileReader.readStringFromFile("success_response.json"))
            }
        }
    }

}