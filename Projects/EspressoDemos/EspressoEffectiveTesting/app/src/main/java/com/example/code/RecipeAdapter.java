package com.example.code;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.code.data.Recipe;
import com.example.code.local.RecipeStore;

import org.jetbrains.annotations.NotNull;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    private final RecipeStore store;

    public RecipeAdapter(RecipeStore store) {
        this.store = store;
    }

    @NotNull
    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {
        final Recipe recipe = store.recipes.get(position);
        holder.textView.setText(recipe.title);
        holder.textView.setOnClickListener(view -> {
            Context context = holder.textView.getContext();
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra(RecipeActivity.KEY_ID, recipe.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return store.recipes.size();
    }
}
