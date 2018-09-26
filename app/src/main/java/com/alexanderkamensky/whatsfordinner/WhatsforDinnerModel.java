package com.alexanderkamensky.whatsfordinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import android.util.Log;
import java.util.Hashtable;

public class WhatsforDinnerModel {
    final private static int debug = 4;
    Hashtable<String, Recipe> reciepes;
    Hashtable<String, Ingredient> ingredients;

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





}
