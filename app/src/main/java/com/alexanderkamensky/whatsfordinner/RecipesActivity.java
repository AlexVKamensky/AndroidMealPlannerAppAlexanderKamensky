package com.alexanderkamensky.whatsfordinner;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {
    ArrayList<String> recipeNameList;
    ArrayAdapter<String> adapter;

    ListView recipeList;

    private WhatsforDinnerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipeList = (ListView)findViewById(R.id.recipeList);

        model = WhatsforDinnerModel.getModel();
        recipeNameList = model.getAllRecipesNames();

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                recipeNameList);

        recipeList.setAdapter(adapter);
    }
}
