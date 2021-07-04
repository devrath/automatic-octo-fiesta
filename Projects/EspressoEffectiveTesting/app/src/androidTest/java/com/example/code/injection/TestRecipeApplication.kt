package com.example.code.injection

import com.example.code.local.Favorites
import com.example.code.local.InMemoryFavorites

class TestRecipeApplication : RecipeApplication() {
    private val favorites: Favorites = InMemoryFavorites()
    override fun getFavorites(): Favorites {
        return favorites
    }
}