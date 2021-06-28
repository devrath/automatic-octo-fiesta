package com.example.code;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.code.data.Recipe;
import com.example.code.local.RecipeStore;
import com.example.code.local.SharedPreferencesFavorites;

public class RecipeActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = findViewById(R.id.title);
        TextView descriptionView = findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        final SharedPreferencesFavorites favorites = new SharedPreferencesFavorites(this);
        boolean favorite = favorites.get(recipe.id);

        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        titleView.setOnClickListener(view -> {
            boolean result = favorites.toggle(recipe.id);
            titleView.setSelected(result);
        });
        descriptionView.setText(recipe.description);
    }
}
