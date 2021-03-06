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


public class FindLocation extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    String floor, block, latitude, longitudek;
    double lat;
    double lng;
    //private Button savemap;
    //TextView txtLat, txtLng;
//    add_kegiatan addKegiatan = new add_kegiatan();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_location);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Intent intent = getIntent();
        floor = intent.getStringExtra("floor");
        block = intent.getStringExtra("block");
        latitude = intent.getStringExtra("lat");
        longitudek = intent.getStringExtra("lng");

        lat = Double.parseDouble(latitude);
        lng = Double.parseDouble(longitudek);

        TextView f = (TextView) findViewById(R.id.textViewFindFloor);
        f.setText(floor);

        TextView b = (TextView) findViewById(R.id.textViewFindBlock);
        b.setText(block);
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

        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title("Your Parking Location"));


    }

//    public Double getLat() {
//        return lat;
//    }
//
//    public Double getLng() {
//        return lng;
//    }

}