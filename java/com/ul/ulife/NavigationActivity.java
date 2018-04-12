package com.ul.ulife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NavigationActivity extends CategoryActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<Building> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Building.buildings);
        ListView buildings = findViewById(R.id.buildings);
        buildings.setAdapter(listAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(NavigationActivity.this, BuildingDetailsActivity.class);
                intent.putExtra("com.ul.ulife.EXTRA_BUILDINGID", (int) id);
                startActivity(intent);
            }
        };
        buildings.setOnItemClickListener(onItemClickListener);

    }


    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_navigation);
    }
}
