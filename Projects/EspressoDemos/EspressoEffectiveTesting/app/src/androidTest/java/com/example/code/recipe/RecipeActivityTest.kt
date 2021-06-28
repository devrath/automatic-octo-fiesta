package com.example.code.recipe

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isSelected
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.code.R
import com.example.code.injection.TestRecipeApplication
import com.example.code.local.InMemoryFavorites
import com.example.code.recipe.RecipeActivity.KEY_ID
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RecipeActivityTest {

    private lateinit var scenario: ActivityScenario<RecipeActivity>
    private lateinit var intent : Intent
    private var favorites: InMemoryFavorites? = null

    companion object{
        const val CHOCOLATE_PUDDING = "chocolate_pudding"
    }

    @Before
    fun setup() {
        val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestRecipeApplication
        favorites = app.favorites as InMemoryFavorites
        favorites?.clear()
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
        launchRecpieScreen(CHOCOLATE_PUDDING)
        // Check if the recipe title and id is displayed
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Chocolate Pudding")))
    }

    @Test
    fun checkOnClickFunctionalityOfFavourite() {
        launchRecpieScreen(CHOCOLATE_PUDDING)
        // Check if the recipe title and id is displayed
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(matches(withText("Chocolate Pudding")))
            .perform(click())
            .check(matches(isSelected()))
    }


    @Test
    fun checkForAlreadyFavourite() {
        favorites?.put(CHOCOLATE_PUDDING,true)

        launchRecpieScreen(CHOCOLATE_PUDDING)
        // Check if the recipe title and id is displayed
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(matches(withText("Chocolate Pudding")))
            .check(matches(isSelected()))
    }

    private fun launchRecpieScreen(input: String) {
        // Add appropriate value to intent
        intent.putExtra(KEY_ID, input)
        // Launch the activity
        scenario = launchActivity(intent)
    }

}