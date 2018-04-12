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


public class BuildingDetailsActivity extends CategoryActivity implements OnMapReadyCallback {


    private int buildingId;
    private MapFragment mMapFragment;
    private String name;
    private double lat;
    private double lng;
    private GoogleMap map;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buildingId = (Integer) getIntent().getExtras().get("com.ul.ulife.EXTRA_BUILDINGID");
        //TODO: check buildingId valid
        Building building = Building.buildings[buildingId];
        this.lat = building.getLat();
        this.lng = building.getLng();
        this.name = building.getName();

        TextView tvName = findViewById(R.id.name);
        tvName.setText(building.getName());

        TextView tvDescription = findViewById(R.id.description);
        tvDescription.setText(building.getDescription());

        ImageView ivBuilding = findViewById(R.id.imageBuilding);
        ivBuilding.setImageResource(building.getImageResourceId());
        ivBuilding.setContentDescription(building.getName());

    }

    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_building_details);
    }


    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public void onClickStuff(View view) {
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            checkLocationPermission();
//        }
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
        } else {
            // Show rationale and request permission.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                Toast.makeText(this, "Allow access to device's location to show your position on map.", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
//                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
//                // MY_PERMISSIONS_REQUEST_LOCATION is an
//                // app-defined int constant. The callback method gets the
//                // result of the request.
//            }
            }
        }
    }

//    public boolean checkLocationPermission() {
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
//                //TODO:show explanation
//
//                //Prompt the user once explanation has been shown
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//
//            } else {
//                // No explanation needed, we can request the permission.
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//            }
//            return false;
//        } else {
//            return true;
//        }
//    }

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
