package com.alexanderkamensky.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class GroceriesActivity extends AppCompatActivity {

    WhatsforDinnerModel model;
    ArrayList<String> groceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        model = WhatsforDinnerModel.getModel();

        model.generateGroceries();

        groceries = model.getGroceries();

        for(String groc: groceries){
            Log.d("Groceries", groc);
        }


    }
}
