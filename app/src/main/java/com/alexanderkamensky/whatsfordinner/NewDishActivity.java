package com.alexanderkamensky.whatsfordinner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class NewDishActivity extends AppCompatActivity {

    private EditText dishEditName;
    private EditText dishEditDirections;
    private ImageView dishImageView;
    private ImageButton dishImageButton;
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
    private Drawable image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish);

        model = WhatsforDinnerModel.getModel();
        recipe = null;
        image = getResources().getDrawable(R.drawable.ic_lemon);

        dishEditName = (EditText) findViewById(R.id.dishEditName);
        dishEditDirections = (EditText) findViewById(R.id.dishEditDirections);
        dishImageView = (ImageView) findViewById(R.id.dishImageView);
        dishImageButton = (ImageButton) findViewById(R.id.dishImageButton);
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

        dishIngredient1.setOnFocusChangeListener(new IngredientListener(0));
        dishIngredient2.setOnFocusChangeListener(new IngredientListener(1));
        dishIngredient3.setOnFocusChangeListener(new IngredientListener(2));
        dishIngredient4.setOnFocusChangeListener(new IngredientListener(3));
        dishIngredient5.setOnFocusChangeListener(new IngredientListener(4));
        dishIngredient6.setOnFocusChangeListener(new IngredientListener(5));
        dishIngredient7.setOnFocusChangeListener(new IngredientListener(6));
        dishIngredient8.setOnFocusChangeListener(new IngredientListener(7));
        dishIngredient9.setOnFocusChangeListener(new IngredientListener(8));
        dishIngredient10.setOnFocusChangeListener(new IngredientListener(9));

        dishEditDirections.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String directions = dishEditDirections.getText().toString();
                    recipeDirectionsUpdate(directions);
                }
            }
        });

        dishImageButton.setOnClickListener(imageListener);
        image =  getResources().getDrawable(R.drawable.ic_lemon);
        Intent intent = getIntent();
        if(intent.getStringExtra("Name") != null){
            String name = intent.getStringExtra("Name");
            recipe = model.getRecipe(name);
            dishEditName.setFocusableInTouchMode(false);
            dishIngredient1.setFocusableInTouchMode(true);
            fillGUI();
        }
    }

    private class IngredientListener implements View.OnFocusChangeListener{
        private int index;

        public IngredientListener(int index){
            this.index = index;
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
                String name = ((AutoCompleteTextView)v).getText().toString();
                recipeIngredientUpdate(name, this.index);
            }
        }
    }

    private void fillGUI(){
        if (recipe != null) {
            String name = recipe.getName();
            String directions = recipe.getDirections();
            //recipe.setImage(image);
            Log.d("Dish", "Name = " + name + " directions = " + directions);
            dishEditName.setText(name);
            dishEditDirections.setText(directions);

            if(recipe.getImage() != null){
                image = recipe.getImage();
            }
            else {
                recipe.setImage(image);
            }
            dishImageView.setImageDrawable(image);

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
        if( ! name.equals("")) {
            if (recipe == null & model.getRecipe(name) == null) {
                Log.d("Dish", "recipeNameUpdate name setting the name = " + name);
                recipe = new Recipe(name);
                model.addRecipe(recipe);
            } else {
                if (recipe == null) {
                    Log.d("Dish", "recipeNameUpdate name setting the name 2 = " + name);
                    recipe = model.getRecipe(name);
                }
                if (recipe.getName() != name) {
                    Recipe anotherRecipe = model.getRecipe(name);
                    if (anotherRecipe != null) {
                        recipe = anotherRecipe;
                    } else {
                        recipe = new Recipe(name);
                        model.addRecipe(recipe);
                    }
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
            recipe.setIngredient(ingredient, index);
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

    private View.OnClickListener imageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
        }
    };

    public void imageSelect(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    public static final int PICK_IMAGE = 1;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            if(resultCode == RESULT_OK) {
                Log.d("ImageSelect", "Found Image");
                Log.d("ImageSelect", "No Crash");
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    if(recipe != null) {
                        Drawable drawImage = new BitmapDrawable(getResources(), selectedImage);
                        image = resize(drawImage);
                        recipe.setImage(image);
                    }
                } catch (FileNotFoundException e) {
                }
                Log.d("ImageSelect", "No Crash 2");
            }
        }
        fillGUI();
    }

    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 100, 100, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // if(recipe != null | ){

       // }
    }
}
