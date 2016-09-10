package com.example.adityalaksana.elepark;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import java.security.Provider;

/**
 * Created by raufimusaddiq on 10/09/16.
 */
public class GPSTracker extends Service implements LocationListener {

    protected LocationManager locationManager;
    String mprovider;
    private Location location;
    private final Context context;

    public GPSTracker(Context context) {
        this.context = context;
        getLocation();
    }

    public Location getLocation(){
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        mprovider = locationManager.getBestProvider(criteria, false);

        if(mprovider != null && !mprovider.equals("")) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            }
            location = locationManager.getLastKnownLocation(mprovider);
            locationManager.requestLocationUpdates(mprovider, (1000 * 5), 1, this);
        }
        if (location != null){
            return location;
        } else {
            return null;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
