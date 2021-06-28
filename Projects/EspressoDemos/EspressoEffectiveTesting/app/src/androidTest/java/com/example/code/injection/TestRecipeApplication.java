package com.example.code.injection;

import com.example.code.local.Favorites;
import com.example.code.local.InMemoryFavorites;

public class TestRecipeApplication extends RecipeApplication{
    private final Favorites favorites = new InMemoryFavorites();
    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
