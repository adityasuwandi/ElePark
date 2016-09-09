package com.example.adityalaksana.elepark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class mainMenu extends AppCompatActivity {
    String floor, block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Intent intent = getIntent();
        floor = intent.getStringExtra("homefloor");
        block = intent.getStringExtra("homeblock");

        TextView f = (TextView) findViewById(R.id.textViewHomeFloor);
        f.setText(floor);
        TextView t = (TextView) findViewById(R.id.textViewHomeBlock);
        t.setText(block);

        ImageButton gotoset = (ImageButton) findViewById(R.id.imageButtonSet);
        gotoset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent setIntent = new Intent(mainMenu.this, FormActivity.class);
                startActivity(setIntent);
            }
        });

        ImageButton gotofind = (ImageButton) findViewById(R.id.imageButtonFind);
        gotofind.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent findIntent = new Intent(mainMenu.this, FindLocation.class);
                intent.putExtra("floor", floor);
                intent.putExtra("block", block);
                startActivity(findIntent);
            }
        });

        ImageButton gotosetting = (ImageButton) findViewById(R.id.settingimg);
        gotosetting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent settingIntent = new Intent(mainMenu.this, Settings.class);
                startActivity(settingIntent);
            }
        });
    }


}
