package com.example.code.recipe

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.code.R
import com.example.code.injection.TestRecipeApplication
import com.example.code.local.InMemoryFavorites
import com.example.code.recipe.RecipeActivity.KEY_ID
import com.example.code.test.RecipeRobot
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class RecipeActivityTest {


    @get:Rule
    val activityRule: ActivityTestRule<RecipeActivity> = ActivityTestRule(RecipeActivity::class.java, true, false)

    private var favorites: InMemoryFavorites? = null

    companion object{
        const val CHOCOLATE_PUDDING = "chocolate_pudding"
    }

    @Before
    fun setup() {
        val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestRecipeApplication
        favorites = app.favorites as InMemoryFavorites
        favorites?.clear()
    }

    @After
    fun cleanup() {
        favorites?.clear()
    }

    @Test
    fun checkRecipeIsNotFound() {
        RecipeRobot()
                .launch(activityRule)
                .noTitle()
                ?.description(R.string.recipe_not_found)
    }

    @Test
    fun checkRecipeIsFound() {
        launchRecipe(CHOCOLATE_PUDDING)
        // Check if the recipe title and id is displayed
        onView(withId(R.id.title))
            .check(matches(withText("Chocolate Pudding")))
    }

    @Test
    fun checkOnClickFunctionalityOfFavourite() {
        launchRecipe(CHOCOLATE_PUDDING)
        // Check if the recipe title and id is displayed
        onView(withId(R.id.title))
            .check(matches(withText("Chocolate Pudding")))
            .perform(click())
            .check(matches(isSelected()))
    }

    @Test
    fun checkForAlreadyFavourite() {
        RecipeRobot()
                .setFavorite(CHOCOLATE_PUDDING)
                .launch(activityRule, CHOCOLATE_PUDDING)
                .isFavorite
    }

    private fun launchRecipe(id: String) {
        val intent = Intent()
        intent.putExtra(KEY_ID, id)
        activityRule.launchActivity(intent)
    }

}