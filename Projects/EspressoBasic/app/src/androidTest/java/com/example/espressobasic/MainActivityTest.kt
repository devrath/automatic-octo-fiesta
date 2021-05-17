package com.example.espressobasic

import android.service.autofill.Validators.not
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Test
    fun greet() {
        onView(withId(R.id.greeting))
            .check(ViewAssertions.matches(withText("")))

        onView(withId(R.id.greet_button))
            .perform(ViewActions.click())

        onView(withId(R.id.greeting))
            .check(ViewAssertions.matches(withText(R.string.hello)))
    }

}