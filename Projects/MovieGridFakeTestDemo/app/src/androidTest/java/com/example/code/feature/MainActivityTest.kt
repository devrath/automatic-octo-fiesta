package com.example.code.feature

import androidx.test.rule.ActivityTestRule
import com.example.code.base.BaseTest
import org.junit.Rule
import org.junit.Test

class MainActivityTest : BaseTest(){


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)


    @Test
    fun testForSuccessfulResponse() {
        successfulServerResponse("success_response.json")
        activityRule.launchActivity(null)
    }

    
}

