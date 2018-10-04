package com.alexanderkamensky.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    WhatsforDinnerModel model;
    RelativeLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ModelTest.testModel(this);
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

    public void inflatePopUp(View view){
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        View popupView = inflater.inflate(R.layout.popup_info, null);

        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );

        ImageButton closeButton = (ImageButton) popupView.findViewById(R.id.mainPopupClose);

        // Set a click listener for the popup window close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss the popup window
                popupWindow.dismiss();
            }
        });

        popupWindow.showAtLocation(findViewById(R.id.mainView), Gravity.CENTER,0,0);
    }
}
