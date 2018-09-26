package com.alexanderkamensky.whatsfordinner;
import android.util.Log;

public class Ingredient {
    final private static int debug = 4;
    private String name;
    private String unit;

    public Ingredient(String name){
        this.name = name;
        if(debug > 0) {
            Log.d("Modeltesting", "Created Ingredient " + this.name);
        }
    }

    public String getName(){
        return this.name;
    }

    public String getUnit(){
        return this.unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
        if(debug > 0){
            String mmsg = "Ingredeint " + this.name + " unit set to " + this.unit;
            Log.d("Modeltesting", mmsg);
        }
    }
}
