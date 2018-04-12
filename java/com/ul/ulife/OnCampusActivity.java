package com.ul.ulife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class OnCampusActivity extends CategoryActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<Restaurant> listAdapter = new ArrayAdapter<>(
                OnCampusActivity.this,
                android.R.layout.simple_list_item_1,
                Restaurant.restaurantsOnCampus);
        ListView restaurants = findViewById(R.id.onCampus);
        restaurants.setAdapter(listAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent1 = new Intent(OnCampusActivity.this, RestaurantOnCampusActivity.class);
                int id1 = (int) id;
                intent1.putExtra("i", id1);
                startActivity(intent1);
            }
        };
        restaurants.setOnItemClickListener(onItemClickListener);

    }


    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_on_campus);
    }
}
