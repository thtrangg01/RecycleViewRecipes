package com.example.recycleviewrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IOnItemClickListener{
    private RecyclerView lstRecipes;
    private RecipesAdapter mAdapter;
    private final LinkedList<Recipes> recipes = new LinkedList<>();

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();

        lstRecipes = findViewById(R.id.lstRecipes);
        mAdapter = new  RecipesAdapter(this, recipes);
        lstRecipes.setAdapter(mAdapter);
        lstRecipes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeData() {
        for (int i = 0; i < 10; i++) {
            String title = "Recipe" + (i+1);
            String description = "Decription" + (i+1);
            String content = "Content" + (i+1);
            Recipes recipe = new Recipes(title, description, content);
            recipes.add(recipe);
        }
    }

    public void openRecipeDetail(Recipes recipe) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", recipe);
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClicked(int position) {
        Recipes recipes = mAdapter.mRecipes.get(position);
        openRecipeDetail(recipes);
    }
}