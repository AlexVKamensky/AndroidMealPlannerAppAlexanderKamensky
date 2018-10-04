package com.alexanderkamensky.whatsfordinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewDebug;

import java.util.ArrayList;
import java.util.Hashtable;

public class ModelTest {

    static private boolean initRun = false;
    public static void testModel(Context context){
        if(initRun){
            return;
        }
        Drawable lemon = context.getResources().getDrawable(R.drawable.ic_lemon);
        Drawable cake = context.getResources().getDrawable(R.drawable.cake);
        initRun = true;
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
        newrecpe1.setIngredient(newingr1, 0);
        newrecpe1.setIngredient(newingr2, 1);
        newrecpe1.setIngredient(newingr3, 2);
        newrecpe1.setIngredient(newingr4, 3);
        newrecpe1.setIngredient(newingr5, 4);
        newrecpe1.setImage(lemon);
        model.addRecipe(newrecpe1);

        Recipe newrecpe2 = new Recipe("Faust Bread");
        newrecpe2.setIngredient(newingr3, 0);
        newrecpe2.setIngredient(newingr1, 1);
        newrecpe2.setIngredient(newingr1, 1);
        newrecpe2.setImage(lemon);
        model.addRecipe(newrecpe2);

        Recipe newrecpe3 = new Recipe("Cake");
        newrecpe3.setIngredient(newingr1, 1);
        newrecpe3.setDirections("Cook great Cake");
        newrecpe3.setImage(cake);
        model.addRecipe(newrecpe3);

        Recipe newrecpe4 = new Recipe("Beef Chop");
        newrecpe4.setIngredient(newingr1, 1);
        newrecpe4.setImage(lemon);
        model.addRecipe(newrecpe4);

        Recipe newrecpe5 = new Recipe("Chicken Salad");
        newrecpe5.setIngredient(newingr1, 1);
        newrecpe5.setImage(lemon);
        model.addRecipe(newrecpe5);

        printRecipesAndIngredientNames(model);

        // update old recipe
        Recipe oldrecipe = model.getRecipe("Cake");
        if(oldrecipe != null) {
            oldrecipe.setIngredient(newingr2, 2);
        }

        model.addMeal(newrecpe1);
        model.addMeal(newrecpe2);
        model.addMeal(newrecpe3);
        model.addMeal(newrecpe4);
        model.addMeal(newrecpe5);
        model.addMeal(newrecpe1);

        Hashtable<String, Integer> unassinged = model.getUnassignedMeals();

        Meal meal1 = model.getUnassignedMealbyRecipe(newrecpe1.getName());
        Meal meal2 = model.getUnassignedMealbyRecipe(newrecpe2.getName());

        model.assignMeal(meal1, 1, Meal.Time.BREAKFAST);

        unassinged = model.getUnassignedMeals();

        model.assignMeal(meal2, 1, Meal.Time.LUNCH);
        unassinged = model.getUnassignedMeals();

    }

    public static void demoSetup(Context context){
        if(initRun){
            return;
        }
        initRun = true;
        Drawable lemon = context.getResources().getDrawable(R.drawable.ic_lemon);
        Drawable cake = context.getResources().getDrawable(R.drawable.cake);
        WhatsforDinnerModel model = WhatsforDinnerModel.getModel();

        Ingredient newingr1 = new Ingredient("Salt");
        model.addIngredient(newingr1);

        Ingredient newingr2 = new Ingredient("Flour");
        model.addIngredient(newingr2);

        Ingredient newingr3 = new Ingredient("Sugar");
        model.addIngredient(newingr3);

        Ingredient newingr4 = new Ingredient("Eggs");
        model.addIngredient(newingr4);

        Ingredient newingr5 = new Ingredient("Buttermilk");
        model.addIngredient(newingr5);

        Ingredient newingr6 = new Ingredient("Baking powder");
        model.addIngredient(newingr6);

        Ingredient newingr7 = new Ingredient("Baking Soda");
        model.addIngredient(newingr7);

        Recipe newrecpe1 = new Recipe("Cake");
        newrecpe1.setIngredient(newingr1, 0);
        newrecpe1.setIngredient(newingr2, 1);
        newrecpe1.setIngredient(newingr3, 2);
        newrecpe1.setIngredient(newingr4, 3);
        newrecpe1.setIngredient(newingr5, 4);
        newrecpe1.setIngredient(newingr6, 5);
        newrecpe1.setIngredient(newingr7, 6);
        newrecpe1.setIngredient(newingr2, 7);
        newrecpe1.setIngredient(newingr3, 8);
        newrecpe1.setDirections("Preheat oven to 350º F. Combine flour, baking powder, baking soda, and salt in a large bowl. Whisk through to combine. Set aside. Cream butter until fluffy and then add sugar. Cream together for about 8 more minutes. Add eggs, one at a time, and mix just until combined. Bake for 25-30 minutes");
        newrecpe1.setImage(cake);
        model.addRecipe(newrecpe1);

        Ingredient newingr8 = new Ingredient("Lettuce");
        model.addIngredient(newingr8);

        Ingredient newingr9 = new Ingredient("Garlic");
        model.addIngredient(newingr9);

        Ingredient newingr10 = new Ingredient("Mayonnaise");
        model.addIngredient(newingr10);

        Ingredient newingr11 = new Ingredient("Croutons");
        model.addIngredient(newingr11);

        Recipe newrecpe2 = new Recipe("Caesar Salad");
        newrecpe2.setIngredient(newingr1, 0);
        newrecpe2.setIngredient(newingr8, 1);
        newrecpe2.setIngredient(newingr9, 2);
        newrecpe2.setIngredient(newingr10, 3);
        newrecpe2.setIngredient(newingr11, 4);
        newrecpe2.setIngredient(newingr1, 5);
        newrecpe2.setIngredient(newingr8, 6);
        newrecpe2.setIngredient(newingr8, 7);
        newrecpe2.setDirections("Mix everything well, then add Mayonnaise.");
        newrecpe2.setImage(lemon);
        model.addRecipe(newrecpe2);

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
