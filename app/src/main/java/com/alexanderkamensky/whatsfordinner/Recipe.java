package com.alexanderkamensky.whatsfordinner;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class Recipe {
    final private static int debug = 4;

    String name;
    String directions;
    Drawable image;
    Ingredient[] ingredients;
    Integer[] amount;

    public Recipe(String name){
        this.name = name;
        this.ingredients = new Ingredient[10];
        this.amount = new Integer[10];
        if(debug > 0) {
            String mmsg = "Recipe " + this.name + " was created";
            Log.d("Modeltesting", mmsg);
        }
    }

    public void setIngredient(Ingredient ing, Integer pos){
        this.ingredients[pos] = ing;
        if(debug > 0) {
            String mmsg = "Put in ingredient " + ing.getName() + " at position " + pos;
            Log.d("Modeltesting", mmsg);
        }
    }

    public void setDirections(String directions){
        this.directions = directions;
        if(debug >0){
            String mmsg = "Recipe " + this.name + " directions set to " + this.directions;
            Log.d("Modeltesting", mmsg);
        }
    }

    public void setImage(Drawable drawImage){
        this.image = drawImage;
    }

    public String getIngredientsString(){
        String ret = "Ingredients: \n";
        ArrayList<String> ingredeints = new ArrayList<String>();
        Hashtable<String, Integer> amounts = new Hashtable<String, Integer>();
        for(Ingredient ingr: this.ingredients){
            if(ingr != null){
                if(ingredeints.contains(ingr.getName())){
                    amounts.put(ingr.getName(), amounts.get(ingr.getName()) +1);
                }
                else{
                    ingredeints.add(ingr.getName());
                    amounts.put(ingr.getName(), 1);
                }
            }
        }
        Collections.sort(ingredeints);
        for(String ingredient: ingredeints){
            ret = ret + ingredient + " (" + amounts.get(ingredient) + ")\n";
        }
        return ret;
    }

    public String getName(){
        return this.name;
    }

    public Ingredient getIngredient(int num){
        return this.ingredients[num];
    }

    public ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> ret = new ArrayList<Ingredient>();
        for(Ingredient ingredient : this.ingredients){
            ret.add(ingredient);
        }
        return ret;
    }

    public Integer getIngredientAmount(int num){
        return this.amount[num];
    }

    public String getDirections(){
        return  this.directions;
    }

    public Drawable getImage() { return  this.image;}



}
