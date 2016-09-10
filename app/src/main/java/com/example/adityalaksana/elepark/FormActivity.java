package com.example.adityalaksana.elepark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    String stringFloor, stringBlock;
    DatabaseHandler db;
    EditText floor, block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        DatabaseHandler db = new DatabaseHandler(this);


        floor = (EditText) findViewById(R.id.editTextFloor);
        block = (EditText) findViewById(R.id.editTextBlock);

        ImageButton gotolocation = (ImageButton) findViewById(R.id.imageButtonNext);
        assert gotolocation != null;
        gotolocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                stringFloor = floor.getText().toString();
                stringBlock = block.getText().toString();
                addData();
                Intent locationIntent = new Intent(getApplicationContext(), myLocation.class);
                locationIntent.putExtra("floor", stringFloor);
                locationIntent.putExtra("block", stringBlock);
                startActivity(locationIntent);
            }
        });

    }

    public void addData(){
        db = new DatabaseHandler(this);
        db.addData(floor.getText().toString(), block.getText().toString(), "", "");
    }

}
