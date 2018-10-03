package com.alexanderkamensky.whatsfordinner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GroceriesListAdapter extends RecyclerView.Adapter<GroceryListItemHolder> {

    private List<String> groceryList;
    private Context context;
    private WhatsforDinnerModel model;

    public GroceriesListAdapter(Context context, List<String> groceryList){
        this.groceryList = groceryList;
        this.context = context;
        this.model = WhatsforDinnerModel.getModel();
    }

    @Override
    public GroceryListItemHolder onCreateViewHolder(ViewGroup parnet, int viewType){
        View layoutView = LayoutInflater.from(parnet.getContext()).inflate(R.layout.grocery_list_item, null);
        GroceryListItemHolder grocery = new GroceryListItemHolder(layoutView);
        return grocery;
    }

    @Override
    public void onBindViewHolder(GroceryListItemHolder holder, int position){
        holder.nameText.setText(model.getGrocery(groceryList.get(position)));
    }

    @Override
    public int getItemCount(){
        return this.groceryList.size();
    }

}
