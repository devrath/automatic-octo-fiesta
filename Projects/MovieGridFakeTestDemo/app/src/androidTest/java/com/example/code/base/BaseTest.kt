package com.example.code.base

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.code.utils.OkHttpIdlingResourceRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.mockwebserver.MockWebServer
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

}