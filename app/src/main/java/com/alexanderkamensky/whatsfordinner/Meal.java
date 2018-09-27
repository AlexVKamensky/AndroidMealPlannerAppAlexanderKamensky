package com.alexanderkamensky.whatsfordinner;

public class Meal {
    private int day;
    private int time;
    private  Recipe recipe;

    public Meal(Recipe recipe){
        this.day = 0;
        this.time = 0;
        this.recipe = recipe;
    }

    public int getDay(){
        return  this.day;
    }

    public int getTime(){
        return this.time;
    }

    public Recipe getRecipe(){
        return this.recipe;
    }

    public String getRecipeName(){
        return this.recipe.getName();
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setTime(int time){
        this.time = time;
    }

    public boolean isUnAssinged(){
        boolean ret = true;
        if(this.day != 0 & this.time != 0){
            ret = false;
        }
        return ret;
    }
}
