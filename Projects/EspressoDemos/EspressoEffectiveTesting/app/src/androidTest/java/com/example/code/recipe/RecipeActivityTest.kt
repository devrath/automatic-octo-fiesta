package com.example.code.recipe

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isSelected
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.code.R
import com.example.code.recipe.RecipeActivity.KEY_ID
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {

    private lateinit var scenario: ActivityScenario<RecipeActivity>
    private lateinit var intent : Intent

    @Before
    fun setup() {
        intent = Intent(ApplicationProvider.getApplicationContext(), RecipeActivity::class.java)
    }

    @After
    fun cleanup() {
        scenario.close()
    }

    @Test
    fun checkRecipeIsNotFound() {
        // Launch the activity
        scenario = launchActivity(intent)
        // Check if the default text view notification is displayed
        Espresso.onView(ViewMatchers.withId(R.id.description))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.recipe_not_found)))
        // Check if the the title text view is not displayed
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun checkRecipeIsFound() {
        // Add appropriate value to intent
        intent.putExtra(KEY_ID,"chocolate_pudding")
        // Launch the activity
        scenario = launchActivity(intent)
        // Check if the recipe title and id is displayed
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Chocolate Pudding")))
    }

    @Test
    fun checkOnClickFunctionalityOfFavourite() {
        // Add appropriate value to intent
        intent.putExtra(KEY_ID,"chocolate_pudding")
        // Launch the activity
        scenario = launchActivity(intent)
        // Check if the recipe title and id is displayed
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(matches(withText("Chocolate Pudding")))
            .perform(click())
            .check(matches(isSelected()))
    }

}