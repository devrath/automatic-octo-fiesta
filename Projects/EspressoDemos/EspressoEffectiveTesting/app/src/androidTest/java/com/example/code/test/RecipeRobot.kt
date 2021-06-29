package com.example.code.test

import android.content.Intent
import androidx.annotation.StringRes
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.code.R
import com.example.code.injection.TestRecipeApplication
import com.example.code.local.InMemoryFavorites
import com.example.code.recipe.RecipeActivity

class RecipeRobot : ScreenRobot<RecipeRobot>() {
    private val favorites: InMemoryFavorites
    fun launch(rule: ActivityTestRule<*>): RecipeRobot {
        rule.launchActivity(null)
        return this
    }

    fun launch(rule: ActivityTestRule<*>, id: String?): RecipeRobot {
        val intent = Intent()
        intent.putExtra(RecipeActivity.KEY_ID, id)
        rule.launchActivity(intent)
        return this
    }

    fun noTitle(): RecipeRobot? {
        return checkIsHidden(R.id.title)
    }

    fun description(@StringRes stringId: Int): RecipeRobot? {
        return checkViewHasText(R.id.description, stringId)
    }

    fun setFavorite(id: String): RecipeRobot {
        favorites.put(id, true)
        return this
    }

    val isFavorite: RecipeRobot?
        get() = checkIsSelected(R.id.title)

    init {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestRecipeApplication
        favorites = app.favorites as InMemoryFavorites
        favorites.clear()
    }
}