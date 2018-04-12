package com.ul.ulife;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantOnCampusActivity extends CategoryActivity implements OnMapReadyCallback {

    private int restaurantId;
    private MapFragment mMapFragment;
    private String name;
    private double lat;
    private double lng;
    private GoogleMap map;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurantId = getIntent().getExtras().getInt("i");
        Restaurant restaurant = Restaurant.restaurantsOnCampus[restaurantId];
        this.lat  = restaurant.getLat();
        this.lng  = restaurant.getLng();
        this.name = restaurant.getName();

        TextView tvName = findViewById(R.id.rName);
        tvName.setText(restaurant.getName());

        TextView tvDescription = findViewById(R.id.rDescription);
        tvDescription.setText(restaurant.getDescription());

        ImageView ivBuilding = findViewById(R.id.imageRestaurant);
        ivBuilding.setImageResource(restaurant.getImageResourceId());
        ivBuilding.setContentDescription(restaurant.getName());

    }


    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_restaurant_on_campus);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public void onClickStuff(View view) {
        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, mMapFragment);
        fragmentTransaction.commit();
        mMapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title(name));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lat, lng)).zoom(15).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        }
        else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                Toast.makeText(this, "Allow access to device's location to show your position on map.", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    showToast("Location access denied.");
                }
                return;
            }
        }
    }
}