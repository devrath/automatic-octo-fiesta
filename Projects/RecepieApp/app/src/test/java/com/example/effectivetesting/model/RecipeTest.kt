package com.example.effectivetesting.model

import com.example.effectivetesting.model.Recipe.staticMethods.readFromStream
import org.junit.Assert.*
import org.junit.Test
import java.io.InputStream

class RecipeTest {

    @Test
    fun `Check if reading of the asset file returns a null value`() {
        val stream = RecipeTest::class.java.getResourceAsStream("/recipes/water.txt")

        readFromStream(stream)?.let {
            val recipe: Recipe = it
            assertNotNull(recipe)
            assertEquals("water", recipe.id)
            assertEquals("Water", recipe.title)
            assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description)
        }

    }


}