package com.alexanderkamensky.whatsfordinner;
import android.util.Log;

public class Recipe {
    final private static int debug = 4;

    String name;
    String directions;
    String image;
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

    public void setIngredient(Ingredient ing, Integer pos, Integer amount){
        this.ingredients[pos] = ing;
        this.amount[pos] = amount;
        if(debug > 0) {
            String mmsg = "Put in ingredient " + ing.getName() + " at position " + pos + " with " + amount + " amount";
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

    public String getName(){
        return this.name;
    }

    public Ingredient getIngredient(int num){
        return this.ingredients[num];
    }

    public Integer getIngredientAmount(int num){
        return this.amount[num];
    }

    public String getDirections(){
        return  this.directions;
    }

}
