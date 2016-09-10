package com.example.adityalaksana.elepark;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;

import java.io.IOException;
import java.util.List;

public class myLocation extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    String floor, block, lat, lng;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        gps = new GPSTracker(getApplicationContext());

        Intent intent = getIntent();
        floor = intent.getStringExtra("floor");
        block = intent.getStringExtra("block");

        ImageButton savelocation = (ImageButton) findViewById(R.id.imageButtonSave);
        savelocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double latd = gps.getLocation().getLatitude();
                double lngd = gps.getLocation().getLongitude();
                lat = String.valueOf(latd);
                lng = String.valueOf(lngd);
                Intent myIntent = new Intent(getApplicationContext(), mainMenu.class);
                myIntent.putExtra("latitude", lat);
                myIntent.putExtra("longitude", lng);
                myIntent.putExtra("homefloor", floor);
                myIntent.putExtra("homeblock", block);
                startActivity(myIntent);
            }
        });
//        txtLat = (TextView) findViewById(R.id.txtLat);
//        txtLng = (TextView) findViewById(R.id.txtLong);
//        savemap = (Button) findViewById(R.id.savemapbtn);
//        savemap.setOnClickListener(new View.OnClickListener() {
//            //Back
//            @Override
//            public void onClick(View view) {
////                Intent myIntent = new Intent(getApplicationContext(), add_kegiatan.class);
////                startActivity(myIntent);
//                Intent intent = new Intent();
//                intent.putExtra("latitude", txtLat.getText().toString());
//                intent.putExtra("longitude", txtLng.getText().toString());
//                setResult(RESULT_OK, intent);
//                onBackPressed();//map
//
//            }
//        });
    }

//    public void onMapSearch(View view) {
//        EditText locationSearch = (EditText) findViewById(R.id.map);
//        String location = locationSearch.getText().toString();
//        List<Address> addressList = null;
//
//        if (location != null || !location.equals("")) {
//            Geocoder geocoder = new Geocoder(this);
//            try {
//                addressList = geocoder.getFromLocationName(location, 1);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Address address = addressList.get(0);
//            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
//            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
//            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//        }
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Memunculkan tombol untuk mengetahui user location & permission nya
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
//        mMap.setOnMapLongClickListener(new OnMapLongClickListener() {
//            @Override
//            public void onMapLongClick(LatLng latLng) {
//                mMap.addCircle(new CircleOptions()
//                        .center(latLng)
//                        .radius(100)
//                        .strokeColor(R.color.colorPrimary)
//                        .fillColor(R.color.colorPrimary));
//                mMap.addMarker(new MarkerOptions().position(latLng).title("Tes"));
//                txtLat.setText(String.valueOf(latLng.latitude));
//                txtLng.setText(String.valueOf(latLng.longitude));
//                lat = latLng.latitude;
//                 lng = latLng.longitude;
////                Toast.makeText(getApplicationContext(), String.valueOf(latLng.latitude) + "," + String.valueOf(latLng.longitude), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}