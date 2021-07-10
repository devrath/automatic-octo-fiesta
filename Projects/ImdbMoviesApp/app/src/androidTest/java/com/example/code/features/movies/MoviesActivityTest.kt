package com.example.code.features.movies

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.rule.ActivityTestRule
import com.example.code.base.BaseTest
import com.example.code.features.login.LoginActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MoviesActivityTest : BaseTest(){



    private lateinit var activityScenario: ActivityScenario<MoviesActivity>

    @Test
    fun testForSuccessfulResponse() {
        successfulServerResponse("success_response.json")
    }

    @Before
    fun setUp() {
        launchActivityUnderTest()
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    /**
     * Launch the screen
     */
    private fun launchActivityUnderTest() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), MoviesActivity::class.java)
        activityScenario = launchActivity(intent)
    }


}

