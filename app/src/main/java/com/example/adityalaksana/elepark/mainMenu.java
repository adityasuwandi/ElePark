package com.example.adityalaksana.elepark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

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
                startActivity(findIntent);
            }
        });

        ImageButton gotosetting = (ImageButton) findViewById(R.id.settingimg);
        gotosetting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent findIntent = new Intent(mainMenu.this, Settings.class);
                startActivity(findIntent);
            }
        });
    }


}
