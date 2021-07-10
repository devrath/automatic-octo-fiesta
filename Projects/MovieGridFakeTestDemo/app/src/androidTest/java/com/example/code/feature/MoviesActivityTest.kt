package com.example.code.feature

import androidx.test.rule.ActivityTestRule
import com.example.code.base.BaseTest
import com.example.code.features.movies.MoviesActivity
import org.junit.Rule
import org.junit.Test

class MoviesActivityTest : BaseTest(){


    @get:Rule
    val activityRule = ActivityTestRule(MoviesActivity::class.java, true, false)


    @Test
    fun testForSuccessfulResponse() {
        successfulServerResponse("success_response.json")
        activityRule.launchActivity(null)
    }


}

