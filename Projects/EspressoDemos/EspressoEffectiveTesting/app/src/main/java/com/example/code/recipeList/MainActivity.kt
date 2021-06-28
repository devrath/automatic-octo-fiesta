package com.example.code.recipeList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.code.R
import com.example.code.local.RecipeStore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recipes)
        val store = RecipeStore(this, "recipes")
        val adapter = RecipeAdapter(store)
        recyclerView.apply {
            setAdapter(adapter);
            setHasFixedSize(true);
            layoutManager = LinearLayoutManager(this@MainActivity);
        }
    }

}