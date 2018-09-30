package com.alexanderkamensky.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GroceriesActivity extends AppCompatActivity {

    WhatsforDinnerModel model;
    ArrayList<String> groceries;

    ArrayAdapter<String> adapter;

    ListView groceriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        groceriesList = (ListView) findViewById(R.id.groceriesList);

        model = WhatsforDinnerModel.getModel();

        model.generateGroceries();

        groceries = model.getGroceries();

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                groceries);

        groceriesList.setAdapter(adapter);

        for(String groc: groceries){
            Log.d("Groceries", groc);
        }


    }
}
