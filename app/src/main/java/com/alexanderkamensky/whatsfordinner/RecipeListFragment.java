package com.alexanderkamensky.whatsfordinner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.R.layout;

import java.util.ArrayList;


public class RecipeListFragment extends Fragment {

    private OnRecipeSelectedListener mListener;

    ArrayList<String> recipeNameList;
    ArrayAdapter<String> adapter;

    ListView recipeList;
    private WhatsforDinnerModel model;

    private OnRecipeSelectedListener listener;
    private String recipeName;


    public RecipeListFragment() {
        // Required empty public constructor
    }


    public static RecipeListFragment newInstance(String param1, String param2) {
        RecipeListFragment fragment = new RecipeListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        recipeList = (ListView) view.findViewById(R.id.recipeList);

        model = WhatsforDinnerModel.getModel();
        recipeNameList = model.getAllRecipesNames();

        adapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1,
                recipeNameList);

        recipeList.setAdapter(adapter);

        recipeList.setOnItemClickListener(RecipeTapListener);

        Log.d("Recipe", "Calling update for Element 0");
        updateDetail((String) recipeNameList.get(0));


        return view;
    }


    private AdapterView.OnItemClickListener RecipeTapListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long agr3) {
            recipeName = (String)adapterView.getItemAtPosition(position);
            Log.d("RecipeLog", "recipeName = " + recipeName);
            updateDetail(recipeName);
        }
    };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecipeSelectedListener) {
            Log.d("Recipe", "listener intialized");
            listener = (OnRecipeSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnRecipeSelectedListener {
        
        void onRecipeSelected(String recipe);
    }

    public void updateDetail(String name) {
        listener.onRecipeSelected(name);
    }
}
