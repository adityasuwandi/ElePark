package com.example.adityalaksana.elepark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    String stringFloor, stringBlock;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        DatabaseHandler db = new DatabaseHandler(this);


        EditText floor = (EditText) findViewById(R.id.editTextFloor);
        stringFloor = floor.getText().toString();

        EditText block = (EditText) findViewById(R.id.editTextBlock);
        stringBlock = block.getText().toString();

        ImageButton gotolocation = (ImageButton) findViewById(R.id.imageButtonNext);
        assert gotolocation != null;
        gotolocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
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
        boolean isInserted = db.addData(stringFloor, stringBlock, "", "");
        if (isInserted){
            Toast.makeText(getApplicationContext(), stringFloor + "&" + stringBlock, Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(getApplicationContext(),"Can't Insert Data" , Toast.LENGTH_SHORT).show();
    }

}
