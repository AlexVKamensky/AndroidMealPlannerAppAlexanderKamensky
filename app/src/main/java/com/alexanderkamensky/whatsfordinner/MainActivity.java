package com.alexanderkamensky.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    WhatsforDinnerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ModelTest.testModel();
    }

    public void launchMeals(View view){
        Intent launchMeals = new Intent(this, MealsActivity.class);

        startActivity(launchMeals);
    }

    public void launchRecipes(View view){
        Intent launchRecipes = new Intent(this, RecipesActivity.class);

        startActivity(launchRecipes);
    }

    public void launchGroceries(View view){
        Intent launchGroceries = new Intent(this, GroceriesActivity.class);

        startActivity(launchGroceries);
    }

    public void launchNewDish(View view){
        Intent launchNewDish = new Intent(this, NewDishActivity.class);

        startActivity(launchNewDish);
    }
}
