package com.example.adityalaksana.elepark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class FormActivity extends AppCompatActivity {
    String stringFloor, stringBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        EditText floor = (EditText) findViewById(R.id.editTextFloor);
        stringFloor = floor.getText().toString();

        EditText block = (EditText) findViewById(R.id.editTextBlock);
        stringBlock = block.getText().toString();

        ImageButton gotolocation = (ImageButton) findViewById(R.id.imageButtonNext);
        assert gotolocation != null;
        gotolocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent locationIntent = new Intent(FormActivity.this, myLocation.class);
                locationIntent.putExtra("floor", stringFloor);
                locationIntent.putExtra("block", stringBlock);
                startActivity(locationIntent);
            }
        });

    }
}
