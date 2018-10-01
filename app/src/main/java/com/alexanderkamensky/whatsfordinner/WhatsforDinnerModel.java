package com.alexanderkamensky.whatsfordinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import android.util.Log;
import java.util.Hashtable;

public class WhatsforDinnerModel {
    final private static int debug = 4;
    Hashtable<String, Recipe> reciepes;
    Hashtable<String, Ingredient> ingredients;
    ArrayList<Meal> meals;
    Hashtable<String, Integer> groceries;

    private static WhatsforDinnerModel currentModel;

    public static WhatsforDinnerModel getModel(){
        if(currentModel == null){
            currentModel = new WhatsforDinnerModel();
        }
        return  currentModel;
    }

    public WhatsforDinnerModel(){
        this.reciepes = new Hashtable<String, Recipe>();
        this.ingredients = new Hashtable<String, Ingredient>();
        this.meals= new ArrayList<Meal>();
        if(debug > 0) {
            Log.d("Modeltesting", "Model intialized");
        }
    }

    public void addRecipe(Recipe recipe){
        this.reciepes.put(recipe.getName(), recipe);
        if(debug > 0) {
            Log.d("Modeltesting", "Recipe " + recipe.getName() + " added");
        }
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.put(ingredient.getName(), ingredient);
        if(debug > 0) {
            Log.d("Modeltesting", "Ingredient " + ingredient.getName() + " added");
        }
    }

    public Recipe getRecipe(String name){
        if(this.reciepes.containsKey(name)) {
            return this.reciepes.get(name);
        }
        else {
            return  null;
        }
    }

    public Ingredient getIngedient(String name){
        if(this.ingredients.containsKey(name)) {
            return this.ingredients.get(name);
        }
        else{
            return null;
        }
    }

    public ArrayList<Ingredient> getAllIngredients(){
        ArrayList<Ingredient> ret = new ArrayList<Ingredient>();
        Enumeration keys = this.ingredients.keys();
        while (keys.hasMoreElements()) {
            ret.add(this.ingredients.get(keys.nextElement()));
        }
        return ret;
    }

    public ArrayList<String> getAllIngredientsNames(){
        ArrayList<String> ret = new ArrayList<String>();
        Enumeration keys = this.ingredients.keys();
        while (keys.hasMoreElements()) {
            ret.add(this.ingredients.get(keys.nextElement()).getName());
        }
        Collections.sort(ret);
        return ret;
    }

    public ArrayList<Recipe> getAllRecipes(){
        ArrayList<Recipe> ret = new ArrayList<Recipe>();
        Enumeration keys = this.reciepes.keys();
        while (keys.hasMoreElements()) {
            ret.add(this.reciepes.get(keys.nextElement()));
        }
        return ret;
    }

    public ArrayList<String> getAllRecipesNames(){
        ArrayList<String> ret = new ArrayList<String>();
        Enumeration keys = this.reciepes.keys();
        while (keys.hasMoreElements()) {
            ret.add(this.reciepes.get(keys.nextElement()).getName());
        }
        Collections.sort(ret);
        return ret;
    }

    public void addMeal(Recipe recipe){
        Meal meal = new Meal(recipe);
        this.meals.add(meal);
        if(debug > 0){
            Log.d("Modeltesting", "Meal " + meal.getRecipeName() + " added");
        }
        if(groceries != null){
            this.updateGroceriesMeal(meal);
        }
    }

    public Hashtable<String, Integer> getUnassignedMeals() {
        Hashtable<String, Integer> unassignedMeals = new Hashtable<String, Integer>();
        for(Meal meal: this.meals){
            if(meal.isUnAssinged()){
                String recipeName = meal.getRecipeName();
                if(unassignedMeals.containsKey(recipeName)){
                    unassignedMeals.put(recipeName, unassignedMeals.get(recipeName) +1);
                }
                else {
                    unassignedMeals.put(recipeName, 1);
                }
                if(debug > 0){
                    Log.d("Modeltesting", "Meal " + meal.getRecipeName() + " is unassigned " + " with  " + unassignedMeals.get(recipeName) + " left");
                }
            }
        }
        return  unassignedMeals;
    }

    public ArrayList<String> getUnassignedMealsList() {
        Hashtable<String, Integer> unassignedMeals = getUnassignedMeals();
        Enumeration<String> keys = unassignedMeals.keys();
        ArrayList<String> ret = new ArrayList<String>();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            ret.add(key);
        }
        Collections.sort(ret);
        return ret;
    }

    public void assignMeal(Meal meal, Integer day, Meal.Time time){
        this.unAssignMeal(day, time);
        meal.setDayTime(day, time);
    }

    public Meal getUnassignedMealbyRecipe(String recipeName){
        for(Meal meal: this.meals){
            if(meal.isUnAssinged()){
                if(meal.getRecipeName() == recipeName){
                    return meal;
                }
            }
        }
        return null;
    }

    public Meal getAssingedMeal(Integer day, Meal.Time time){
        for(Meal meal: this.meals){
            if(meal.getDay() == day & meal.getTime() == time){
                return meal;
            }
        }
        return null;
    }

    public void unAssignMeal(Integer day, Meal.Time time){
        Meal meal = this.getAssingedMeal(day, time);
        if(meal != null) {
            meal.setUnassinged();
        }
    }

    public void generateGroceries(){
        this.groceries = new Hashtable<String, Integer>();

        for(Meal meal: this.meals){
            this.updateGroceriesMeal(meal);
        }
    }

    public void updateGroceriesMeal(Meal meal){
        Recipe recipe = meal.getRecipe();

        ArrayList<Ingredient> ingredients = recipe.getIngredients();
        for(Ingredient ingredient: ingredients){
            if(ingredient != null) {
                String key = ingredient.getName();
                if (groceries.containsKey(key)) {
                    groceries.put(key, groceries.get(key) + 1 );
                }
                else{
                    groceries.put(key, 1);
                }
                if(debug > 0) {
                    Log.d("Groceries", "Added  " + key + " for " + groceries.get(key));
                }
            }
        }
    }

    public ArrayList<String> getGroceries(){
        Enumeration<String> keys = groceries.keys();
        ArrayList<String> ret = new ArrayList<String>();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            Integer amount = groceries.get(key);
            if(amount > 1) {
                ret.add(key + " (" +amount + ")");
            }
            else {
                ret.add(key);
            }
        }
        Collections.sort(ret);
        return ret;
    }
}