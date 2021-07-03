package com.example.code.feature

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.code.BaseTest
import com.example.code.utils.FileReader
import com.example.code.utils.OkHttpIdlingResourceRule
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule = OkHttpIdlingResourceRule()

    val portNumber = 8080

    val mockWebServer = MockWebServer()


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    @Throws
    fun setup() {
        mockWebServer.start(portNumber)
    }

    @Test
    fun testForSuccessfulResponse() {
        successfulServerResponse()
        activityRule.launchActivity(null)
    }

    private fun successfulServerResponse() {
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(FileReader.readStringFromFile("success_response.json"))
            }
        }
    }

    @After
    @Throws
    fun teardown() {
        mockWebServer.shutdown()
    }
}

