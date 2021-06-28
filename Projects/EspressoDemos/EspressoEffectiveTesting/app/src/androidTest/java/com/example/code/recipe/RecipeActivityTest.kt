package com.example.code.recipe

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.code.R
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {

    private lateinit var scenario: ActivityScenario<RecipeActivity>

    @Before
    fun setup() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), RecipeActivity::class.java)
        scenario = launchActivity(intent)
    }

    @After
    fun cleanup() {
        scenario.close()
    }

    @Test
    fun recipeNotFound() {
        // Check if the default text view notification is displayed
        Espresso.onView(ViewMatchers.withId(R.id.description))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.recipe_not_found)))
        // Check if the the title text view is not displayed - this id is from recycler view row
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }
}