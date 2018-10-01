package com.alexanderkamensky.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MealsActivity extends AppCompatActivity {

    private TextView dayText;
    private Spinner breakfastSpinner;
    private Spinner lunchSpinner;
    private Spinner dinnerSpinner;

    Integer day;

    WhatsforDinnerModel model;

    ArrayAdapter<String> breakfastAdapter;
    ArrayAdapter<String> lunchAdapter;
    ArrayAdapter<String> dinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        dayText = (TextView) findViewById(R.id.mealsDayText);
        breakfastSpinner = (Spinner) findViewById(R.id.mealsBreakfastSpinner);
        lunchSpinner = (Spinner) findViewById(R.id.mealsLunchSpinner);
        dinnerSpinner = (Spinner) findViewById(R.id.mealsDinnerSpinner);

        model = WhatsforDinnerModel.getModel();

        ArrayList<String> breakfastOptions = new ArrayList<String>();
        ArrayList<String> lunchOptions = new ArrayList<String>();
        ArrayList<String> dinnerOptions = new ArrayList<String>();

        breakfastOptions.add("Eat Out");
        lunchOptions.add("Eat Out");
        dinnerOptions.add("Eat Out");

        breakfastAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, breakfastOptions);
        breakfastAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lunchAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lunchOptions);
        lunchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dinnerOptions);
        dinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        breakfastSpinner.setAdapter(breakfastAdapter);
        lunchSpinner.setAdapter(lunchAdapter);
        dinnerSpinner.setAdapter(dinnerAdapter);

        breakfastSpinner.setOnItemSelectedListener(new MealListener(Meal.Time.BREAKFAST));
        lunchSpinner.setOnItemSelectedListener(new MealListener(Meal.Time.LUNCH));
        dinnerSpinner.setOnItemSelectedListener(new MealListener(Meal.Time.DINNER));

        day = 1;
        fillGui();
    }

    private class MealListener implements AdapterView.OnItemSelectedListener {
        private Meal.Time time;

        public MealListener(Meal.Time time){
            this.time = time;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
            String choice = adapterView.getItemAtPosition(pos).toString();
            Log.d("Meals", "Choice is " + choice );
            if(choice == "Eating Out"){
                model.unAssignMeal(day, time);
            }else {
                Meal meal = model.getUnassignedMealbyRecipe(choice);
                if(meal != null) {
                    Log.d("Meals", "Meal is " + meal.getRecipeName());
                    model.assignMeal(meal, day, time);
                }
                else{
                    Log.d("Meals", "Meal is null");
                }
            }
            fillGui();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    public void fillGui(){
        setDay();
        generateOptions();
    }

    public void generateOptions(){
        ArrayList<String> breakfastOptions = new ArrayList<String>();
        ArrayList<String> lunchOptions = new ArrayList<String>();
        ArrayList<String> dinnerOptions = new ArrayList<String>();

        Meal breakfast = model.getAssingedMeal(day, Meal.Time.BREAKFAST);
        Meal lunch = model.getAssingedMeal(day, Meal.Time.LUNCH);
        Meal dinner = model.getAssingedMeal(day, Meal.Time.DINNER);

        if (breakfast != null) {
            breakfastOptions.add(breakfast.getRecipeName());
        }
        breakfastOptions.add("Eating Out");

        if (lunch != null) {
            lunchOptions.add(lunch.getRecipeName());
        }
        lunchOptions.add("Eating Out");

        if (dinner != null) {
            dinnerOptions.add(dinner.getRecipeName());
        }
        dinnerOptions.add("Eating Out");

        ArrayList<String> unassigned = model.getUnassignedMealsList();
        for(String meal: unassigned){
            Log.d("Meals", meal);
        }
        breakfastOptions.addAll(unassigned);
        lunchOptions.addAll(unassigned);
        dinnerOptions.addAll(unassigned);

        breakfastAdapter.clear();
        lunchAdapter.clear();
        dinnerAdapter.clear();

        breakfastAdapter.addAll(breakfastOptions);
        lunchAdapter.addAll(lunchOptions);
        dinnerAdapter.addAll(dinnerOptions);

        breakfastSpinner.setSelection(0);
        lunchSpinner.setSelection(0);
        dinnerSpinner.setSelection(0);
    }

    private void setDay(){
        if( day == 1){
            dayText.setText("Monday");
        }
        else if( day == 2){
            dayText.setText("Tuesday");
        }
        else if( day == 3){
            dayText.setText("Wednesday");
        }
        else if( day == 4){
            dayText.setText("Thursday");
        }
        else if( day == 5){
            dayText.setText("Friday");
        }
        else if( day == 6){
            dayText.setText("Saturday");
        }
        else if( day == 7){
            dayText.setText("Sunday");
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void prevDay(View view){
        if(day > 1){
            day = day -1;
            fillGui();
        }
    }
    public void nextDay(View view){
        if(day < 7){
            day = day + 1;
            fillGui();
        }
    }
}
