package com.example.adityalaksana.elepark;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import java.util.Set;

public class Settings extends AppCompatActivity {
    String floor, block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        floor = intent.getStringExtra("floor");
        block = intent.getStringExtra("block");

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    createNotification();
                } else {
                    cancelNotification();
                }
            }
        });}

    public void createNotification() {

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setContentTitle("ElePark");
        nBuilder.setContentText("You are Parking on floor "+floor+" block "+block);
        nBuilder.setSmallIcon(R.drawable.button);


        Notification notification = nBuilder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1, notification);

    }

    public void cancelNotification() {
        NotificationManager MM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        MM.cancelAll();
    }
}