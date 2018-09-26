package com.alexanderkamensky.whatsfordinner;

import android.util.Log;
import android.view.ViewDebug;

import java.util.ArrayList;

public class ModelTest {

    public static void testModel(){
        WhatsforDinnerModel model = WhatsforDinnerModel.getModel();

        // Ingridients
        Ingredient newingr1 = new Ingredient("Salt");
        newingr1.setUnit("Spoon");
        model.addIngredient(newingr1);

        Ingredient newingr2 = new Ingredient("Sugar");
        newingr2.setUnit("Cup");
        model.addIngredient(newingr2);

        Ingredient newingr3 =  new Ingredient("Rice");
        newingr3.setUnit("Cup");
        model.addIngredient(newingr3);

        Ingredient newingr4 =  new Ingredient("Potato");
        newingr4.setUnit("Pieces");
        model.addIngredient(newingr4);

        Ingredient newingr5 = new Ingredient("Tomato");
        newingr5.setUnit("Pieces");
        model.addIngredient(newingr5);

        Ingredient newingr6 =  new Ingredient("Milk");
        newingr6.setUnit("Cup");
        model.addIngredient(newingr6);

        Ingredient newingr7 = new Ingredient("Vingear");
        newingr7.setUnit("Cup");
        model.addIngredient(newingr7);

        Ingredient newingr8 =  new Ingredient("Red Wine");
        newingr8.setUnit("Cup");
        model.addIngredient(newingr8);

        Ingredient newingr9 =  new Ingredient("Bread");
        newingr9.setUnit("Loaves");
        model.addIngredient(newingr9);

        Ingredient newingr10 =  new Ingredient("Fish");
        newingr10.setUnit("Pieces");
        model.addIngredient(newingr10);

        Ingredient newingr11 =  new Ingredient("Chicken");
        newingr11.setUnit("Grams");
        model.addIngredient(newingr11);

        Ingredient newingr12 =  new Ingredient("Beef");
        newingr12.setUnit("Grams");
        model.addIngredient(newingr12);

        Recipe newrecpe1 = new Recipe("Spaghetti");
        newrecpe1.setIngredient(newingr1, 0, 2);
        newrecpe1.setIngredient(newingr2, 1, 3);
        newrecpe1.setIngredient(newingr3, 2, 2);
        newrecpe1.setIngredient(newingr4, 3, 1);
        newrecpe1.setIngredient(newingr5, 4, 2);
        model.addRecipe(newrecpe1);

        Recipe newrecpe2 = new Recipe("Faust Bread");
        newrecpe2.setIngredient(newingr3, 0, 3);
        newrecpe2.setIngredient(newingr1, 1, 2);
        newrecpe1.setIngredient(newingr1, 1, 2);
        model.addRecipe(newrecpe2);

        Recipe newrecpe3 = new Recipe("Cake");
        newrecpe3.setIngredient(newingr1, 1, 2);
        newrecpe3.setDirections("Cook great Cake");
        model.addRecipe(newrecpe3);

        Recipe newrecpe4 = new Recipe("Beef Chop");
        newrecpe4.setIngredient(newingr1, 1, 2);
        model.addRecipe(newrecpe4);

        Recipe newrecpe5 = new Recipe("Chicken Salad");
        newrecpe5.setIngredient(newingr1, 1, 2);
        model.addRecipe(newrecpe5);

        printRecipesAndIngredientNames(model);

        // update old recipe
        Recipe oldrecipe = model.getRecipe("Cake");
        if(oldrecipe != null) {
            oldrecipe.setIngredient(newingr2, 2, 3);
        }







    }


    public static void printArrayString(String prefix, ArrayList<String> list){

        for(String name : list){
            Log.d("Modeltesting", prefix + name);
        }

    }

    public static void printRecipesAndIngredientNames(WhatsforDinnerModel model){
        ArrayList<String> ingrNames = model.getAllIngredientsNames();
        Log.d("Modeltesting", Integer.toString(ingrNames.size()));
        printArrayString("Ingredient name is ", ingrNames);

        ArrayList<String> recNames = model.getAllRecipesNames();
        Log.d("Modeltesting", Integer.toString(recNames.size()));
        printArrayString("Reciepe name is ", recNames);

    }
}