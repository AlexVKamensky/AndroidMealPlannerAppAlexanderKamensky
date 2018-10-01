package com.alexanderkamensky.whatsfordinner;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity implements
    RecipeListFragment.OnRecipeSelectedListener{
    ArrayList<String> recipeNameList;
    ArrayAdapter<String> adapter;

    String currentRecipe;
    ListView recipeList;

    private WhatsforDinnerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        model = WhatsforDinnerModel.getModel();
    }

    @Override
    public void onRecipeSelected(String recipeName) {

        if(currentRecipe == recipeName){
            model.addMeal(model.getRecipe(recipeName));
        }
        currentRecipe = recipeName;

        Log.d("Recipe ", "Trying to set " + recipeName );

        RecipeDetailFragment recipeDetailFragment = (RecipeDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.recipeDetailFragment);

        if (recipeDetailFragment != null && recipeDetailFragment.isInLayout()) {
            Log.d("Recipe ", "Conditions met for  " + recipeName );
            recipeDetailFragment.setRecipe(recipeName);
        }
    }

    public void onRecipeLongSelected(String recipeName){
        Intent recipePass = new Intent(this, NewDishActivity.class);
        recipePass.putExtra("Name", recipeName);
        startActivity(recipePass);
    }
}

