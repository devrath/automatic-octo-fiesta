package com.example.code.injection;

import android.app.Application;

import com.example.code.local.Favorites;
import com.example.code.local.SharedPreferencesFavorites;

public class RecipeApplication extends Application {
    private Favorites favorites = null;

    public Favorites getFavorites() {
        if (favorites == null) {
            favorites = new SharedPreferencesFavorites(this);
        }
        return favorites;
    }
}
