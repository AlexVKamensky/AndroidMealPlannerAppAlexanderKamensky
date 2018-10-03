package com.alexanderkamensky.whatsfordinner;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GroceriesActivity extends AppCompatActivity {

    WhatsforDinnerModel model;
    ArrayList<String> groceries;

    ItemTouchHelper itemTouchHelper;

    private RecyclerView groceriesListView;
    private LinearLayoutManager layoutManager;
    private GroceriesListAdapter groceriesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        groceriesListView = (RecyclerView) findViewById(R.id.GroceriesListView);
        layoutManager = new LinearLayoutManager(GroceriesActivity.this);
        groceriesListView.setLayoutManager(layoutManager);
        model = WhatsforDinnerModel.getModel();
        model.generateGroceries();

        groceries = model.getGroceries();

        groceriesAdapter = new GroceriesListAdapter(GroceriesActivity.this, groceries);
        groceriesListView.setAdapter(groceriesAdapter);

        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(groceriesListView);

        for(String groc: groceries){
            Log.d("Groceries", groc);
        }
    }

    private ItemTouchHelper.SimpleCallback simpleCallback =
            new ItemTouchHelper.SimpleCallback(0,
                    ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView,
                              @NonNull RecyclerView.ViewHolder viewHolder,
                              @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Log.d("Groceries", "Cheeki Breeki iv Damke");
            GroceryListItemHolder item = (GroceryListItemHolder) viewHolder;
            item.switchVisiblity();

            // Workaround to reset swiped out views
            // looks crazy but it works suggested by
            // https://stackoverflow.com/questions/31787272/android-recyclerview-itemtouchhelper-revert-swipe-and-restore-view-holder
            itemTouchHelper.attachToRecyclerView(null);
            itemTouchHelper.attachToRecyclerView(groceriesListView);
        }
    };
}
