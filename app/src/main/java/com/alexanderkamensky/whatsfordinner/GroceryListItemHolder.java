package com.alexanderkamensky.whatsfordinner;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GroceryListItemHolder extends RecyclerView.ViewHolder {
    public TextView nameText;
    public ImageButton addButton;
    public ImageButton removeButton;

    private WhatsforDinnerModel model;

    public String GroceryName;


    public GroceryListItemHolder(View grocerylist){
        super(grocerylist);
        model = WhatsforDinnerModel.getModel();
        nameText = (TextView) grocerylist.findViewById(R.id.groceryListTextView);
        addButton = (ImageButton) grocerylist.findViewById(R.id.groceryListAddButton);
        removeButton = (ImageButton) grocerylist.findViewById(R.id.groceryListRemoveButton);
        addButton.setOnClickListener(addListner);
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

    View.OnClickListener addListner = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Log.d("GroceryHolder", GroceryName);
            int amount = model.groceries.get(GroceryName) + 1;
            if(amount == 1){
                nameText.setPaintFlags(nameText.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            }
            model.groceries.put(GroceryName, amount);
            nameText.setText(model.getGrocery(GroceryName));
        }
    };

    View.OnClickListener removeListner = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Log.d("GroceryHolder", GroceryName);
            int amount = model.groceries.get(GroceryName);
            if(amount != 0) {
                amount = amount -1;
                if(amount == 0){
                    nameText.setPaintFlags(nameText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                model.groceries.put(GroceryName, amount);
                nameText.setText(model.getGrocery(GroceryName));
            }
        }
    };
}
