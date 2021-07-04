package com.example.code.local

import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

class RecipeStoreTest {

    @Test
    fun checkIfRecipesStoreHandlesNullDirectoryProperly() {
        // Get the context reference to the app
        // Target context returns the context for the app
        // GetContext returns the context for the test
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val recipeStore = RecipeStore(context,null)
        // Test for the nullability of the class
        assertNotNull(recipeStore)
        // Test if the recipes collection is having a null value
        assertNotNull(recipeStore.recipes)
        // Test if the size of the collection inside is zero
        assertEquals(0,recipeStore.recipes.size)
    }

    @Test
    fun checkIfThereAreRecipesUnderTheRecipesDirectory() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val recipeStore = RecipeStore(context,"recipes")
        assertNotNull(recipeStore)
        assertNotNull(recipeStore.recipes)
        // Since there are 4 items in recipe folder, check for the size of size of recipes is 4
        assertEquals(4,recipeStore.recipes.size)
    }

    @Test
    fun checkForTheChocolatePuddingRecipe() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val recipeStore = RecipeStore(context,"recipes")
        val recipe = recipeStore.getRecipe("chocolate_pudding")
        assertNotNull(recipe)
        assertEquals("chocolate_pudding",recipe.id)
        assertEquals("Chocolate Pudding",recipe.title)
        assertEquals("2 tablespoons chocolate\n" +
                "yolks of 4 eggs\n" +
                "1 cup sugar\n" +
                "1 quart milk\n" +
                "1 whole egg\n" +
                "2 tablespoons corn starch\n" +
                "\n" +
                "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred.",recipe.description)
    }

}