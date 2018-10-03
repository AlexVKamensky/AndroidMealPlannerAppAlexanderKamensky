package com.alexanderkamensky.whatsfordinner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GroceryListItemHolder extends RecyclerView.ViewHolder {
    public TextView nameText;
    public ImageButton addButton;
    public ImageButton removeButton;

    public String GroceryName;

    public GroceryListItemHolder(View grocerylist){
        super(grocerylist);
        nameText = (TextView) grocerylist.findViewById(R.id.groceryListTextView);
        addButton = (ImageButton) grocerylist.findViewById(R.id.groceryListAddButton);
        removeButton = (ImageButton) grocerylist.findViewById(R.id.groceryListRemoveButton);
    }

    public void switchVisiblity(){
        int visability = addButton.getVisibility();
        if(visability == View.VISIBLE){
            visability = View.INVISIBLE;
        }
        else{
            visability = View.VISIBLE;
        }
        addButton.setVisibility(visability);
        removeButton.setVisibility(visability);
    }
}
