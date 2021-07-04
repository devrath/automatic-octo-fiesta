package com.example.code.data

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Test

class RecipeTest {

    @Test
    fun `read from stream for water text file`() {
        val stream = RecipeTest::class.java.getResourceAsStream("/recipes/water.txt")
        val recipe = Recipe.readFromStream(stream)
        assertNotNull(recipe)
        assertNotNull("water", recipe.id)
        assertEquals("Water", recipe.title)
        Assert.assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description)
    }

    @Test
    fun `read from stream for mixed text file`() {
        val stream = RecipeTest::class.java.getResourceAsStream("/recipes/mixed.txt")
        val recipe = Recipe.readFromStream(stream)
        assertNotNull(recipe)
        assertEquals("punch", recipe.id)
        assertEquals("Juice of 3 lemons\n" +
                                "1 orange\n" +
                                "1 pint grape juice\n" +
                                "1 cup sugar\n" +
                                "1 cup water\n" +
                                "1 pine apple juice\n" +
                                "Mix all together and strain. Add large piece of ice.", recipe.description)
        //Assert.assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description)
    }

}