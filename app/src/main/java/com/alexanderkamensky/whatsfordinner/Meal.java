package com.alexanderkamensky.whatsfordinner;

public class Meal {
    enum Time{
        UNASSIGNED, BREAKFAST, LUNCH, DINNER;
    }
    private int day;
    private Time time;
    private  Recipe recipe;

    public Meal(Recipe recipe){
        this.day = 0;
        this.time = Time.UNASSIGNED;
        this.recipe = recipe;
    }

    public int getDay(){
        return  this.day;
    }

    public Meal.Time getTime(){
        return this.time;
    }

    public Recipe getRecipe(){
        return this.recipe;
    }

    public String getRecipeName(){
        return this.recipe.getName();
    }

    public void setDayTime(int day, Meal.Time time){
        this.day = day;
        this.time = time;
    }

    public void setUnassinged(){
        this.day = 0;
        this.time = Time.UNASSIGNED;
    }
    public boolean isUnAssinged(){
        boolean ret = true;
        if(this.day != 0 & this.time != Time.UNASSIGNED){
            ret = false;
        }
        return ret;
    }
}
