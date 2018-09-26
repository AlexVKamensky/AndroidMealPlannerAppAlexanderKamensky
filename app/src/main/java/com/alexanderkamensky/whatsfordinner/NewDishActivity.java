package com.alexanderkamensky.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class NewDishActivity extends AppCompatActivity {

    private EditText dishEditName;
    private EditText dishEditDirections;
    private AutoCompleteTextView dishIngredient1;
    private AutoCompleteTextView dishIngredient2;
    private AutoCompleteTextView dishIngredient3;
    private AutoCompleteTextView dishIngredient4;
    private AutoCompleteTextView dishIngredient5;
    private AutoCompleteTextView dishIngredient6;
    private AutoCompleteTextView dishIngredient7;
    private AutoCompleteTextView dishIngredient8;
    private AutoCompleteTextView dishIngredient9;
    private AutoCompleteTextView dishIngredient10;

    private Recipe recipe;
    private WhatsforDinnerModel model;

    private ArrayAdapter<String> adapter;

    private String[] COUNTRIES = new String[]
    {
        "Belgium", "France", "Italy", "Germany", "Spain"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish);

        model = WhatsforDinnerModel.getModel();
        recipe = null;

        dishEditName = (EditText) findViewById(R.id.dishEditName);
        dishEditDirections = (EditText) findViewById(R.id.dishEditDirections);
        dishIngredient1 = (AutoCompleteTextView) findViewById(R.id.dishIngredient1);
        dishIngredient2 = (AutoCompleteTextView) findViewById(R.id.dishIngredient2);
        dishIngredient3 = (AutoCompleteTextView) findViewById(R.id.dishIngredient3);
        dishIngredient4 = (AutoCompleteTextView) findViewById(R.id.dishIngredient4);
        dishIngredient5 = (AutoCompleteTextView) findViewById(R.id.dishIngredient5);
        dishIngredient6 = (AutoCompleteTextView) findViewById(R.id.dishIngredient6);
        dishIngredient7 = (AutoCompleteTextView) findViewById(R.id.dishIngredient7);
        dishIngredient8 = (AutoCompleteTextView) findViewById(R.id.dishIngredient8);
        dishIngredient9 = (AutoCompleteTextView) findViewById(R.id.dishIngredient9);
        dishIngredient10 = (AutoCompleteTextView) findViewById(R.id.dishIngredient10);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, model.getAllIngredientsNames());
        dishIngredient1.setAdapter(adapter);
        dishIngredient1.setThreshold(1);
        dishIngredient2.setAdapter(adapter);
        dishIngredient2.setThreshold(1);
        dishIngredient3.setAdapter(adapter);
        dishIngredient3.setThreshold(1);
        dishIngredient4.setAdapter(adapter);
        dishIngredient4.setThreshold(1);
        dishIngredient5.setAdapter(adapter);
        dishIngredient5.setThreshold(1);
        dishIngredient6.setAdapter(adapter);
        dishIngredient6.setThreshold(1);
        dishIngredient7.setAdapter(adapter);
        dishIngredient7.setThreshold(1);
        dishIngredient8.setAdapter(adapter);
        dishIngredient8.setThreshold(1);
        dishIngredient9.setAdapter(adapter);
        dishIngredient9.setThreshold(1);
        dishIngredient10.setAdapter(adapter);
        dishIngredient10.setThreshold(1);

        dishEditName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishEditName.getText().toString();
                    recipeNameUpdate(name);
                }
            }
        });

        dishIngredient1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient1.getText().toString();
                    recipeIngredientUpdate(name, 0);
                }
            }
        });

        dishIngredient2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient2.getText().toString();
                    recipeIngredientUpdate(name, 1);
                }
            }
        });

        dishIngredient3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient3.getText().toString();
                    recipeIngredientUpdate(name, 2);
                }
            }
        });

        dishIngredient4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient4.getText().toString();
                    recipeIngredientUpdate(name, 3);
                }
            }
        });

        dishIngredient5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient5.getText().toString();
                    recipeIngredientUpdate(name, 4);
                }
            }
        });

        dishIngredient6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient6.getText().toString();
                    recipeIngredientUpdate(name, 5);
                }
            }
        });

        dishIngredient7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient7.getText().toString();
                    recipeIngredientUpdate(name, 6);
                }
            }
        });

        dishIngredient8.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient8.getText().toString();
                    recipeIngredientUpdate(name, 7);
                }
            }
        });

        dishIngredient9.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient9.getText().toString();
                    recipeIngredientUpdate(name, 8);
                }
            }
        });

        dishIngredient10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = dishIngredient10.getText().toString();
                    recipeIngredientUpdate(name, 9);
                }
            }
        });

        dishEditDirections.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String directions = dishEditDirections.getText().toString();
                    recipeDirectionsUpdate(directions);
                }
            }
        });

    }

    private void fillGUI(){
        if (recipe != null) {
            String name = recipe.getName();
            String directions = recipe.getDirections();

            Log.d("Dish", "Name = " + name + " directions = " + directions);
            dishEditName.setText(name);
            dishEditDirections.setText(directions);

            dishIngredient1.setText(getRecipeIngredientName(0));
            dishIngredient2.setText(getRecipeIngredientName(1));
            dishIngredient3.setText(getRecipeIngredientName(2));
            dishIngredient4.setText(getRecipeIngredientName(3));
            dishIngredient5.setText(getRecipeIngredientName(4));
            dishIngredient6.setText(getRecipeIngredientName(5));
            dishIngredient7.setText(getRecipeIngredientName(6));
            dishIngredient8.setText(getRecipeIngredientName(7));
            dishIngredient9.setText(getRecipeIngredientName(8));
            dishIngredient10.setText(getRecipeIngredientName(9));
        }
        adapter.clear();
        adapter.addAll(model.getAllIngredientsNames());
    }

    private String getRecipeIngredientName(int index){
        String ret = null;
        Ingredient ingredient = recipe.getIngredient(index);
        if (ingredient != null){
            ret = ingredient.getName();
        }
        return  ret;
    }
    private void recipeNameUpdate(String name){
        Log.d("Dish", "recipeNameUpdate name = " + name);
        if(recipe == null){
            recipe = new Recipe(name);
            model.addRecipe(recipe);
        }else {
            if (recipe.getName() != name) {
                Recipe anotherRecipe = model.getRecipe(name);
                if (anotherRecipe != null) {
                    recipe = anotherRecipe;
                }
                else {
                    recipe = new Recipe(name);
                    model.addRecipe(recipe);
                }
            }
        }
        fillGUI();
        //ModelTest.printRecipesAndIngredientNames(model);
    }

    private void recipeIngredientUpdate(String name, int index){
        Log.d("Dish", "recipeIngredientUpdate name = " + name + " index = " + Integer.toString(index));
        if(recipe != null){
            Ingredient ingredient = model.getIngedient(name);
            if(ingredient == null){
                ingredient = new Ingredient(name);
                model.addIngredient(ingredient);
            }
            recipe.setIngredient(ingredient, index, 1);
        }
        fillGUI();
    }

    private void recipeDirectionsUpdate(String directions){
        Log.d("Dish", "recipeDirectionsUpdate directions = " + directions);
        if(recipe != null){
            recipe.setDirections(directions);
        }
        fillGUI();
    }

}
