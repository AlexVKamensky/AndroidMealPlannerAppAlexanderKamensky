package com.alexanderkamensky.whatsfordinner;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailFragment extends Fragment {

    WhatsforDinnerModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Recipe", "This is on createView");
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        model = WhatsforDinnerModel.getModel();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setRecipe(null);
    }

    public void setRecipe (String recipeName) {
        if(recipeName == null){
            recipeName = model.getAllRecipesNames().get(0);
        }
        Recipe recipe = model.getRecipe(recipeName);

        TextView nameView = (TextView) getView().findViewById(R.id.recipeDetailName);
        ImageView imageView = (ImageView) getView().findViewById(R.id.recipeDetailImage);
        TextView ingredientView = (TextView) getView().findViewById(R.id.recipeDetailIngredients);
        TextView directionsView = (TextView) getView().findViewById(R.id.recipeDetailDirections);

        nameView.setText(recipeName);
        imageView.setImageResource(recipe.getImage());
        ingredientView.setText(recipe.getIngredientsString());
        directionsView.setText(recipe.getDirections());
    }
}
