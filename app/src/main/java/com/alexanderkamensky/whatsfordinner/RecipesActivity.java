package com.alexanderkamensky.whatsfordinner;

import android.support.v4.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity implements
    RecipeListFragment.OnRecipeSelectedListener{
    ArrayList<String> recipeNameList;
    ArrayAdapter<String> adapter;

    ListView recipeList;

    private WhatsforDinnerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

    }
    @Override
    public void onRecipeSelected(String recipeName) {

        RecipeDetailFragment recipeDetailFragment = (RecipeDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.recipeDetailFragment);

        if (recipeDetailFragment != null && recipeDetailFragment.isInLayout()) {
            recipeDetailFragment.setRecipe(recipeName);
        }

    }
}
