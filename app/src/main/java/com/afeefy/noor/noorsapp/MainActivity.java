package com.afeefy.noor.noorsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText etSearch;
    private ImageButton btnLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch=(EditText)findViewById(R.id.etSearch);
        btnLocation=(ImageButton)findViewById(R.id.btnLocation);
    }
    private void dataHandler(){
        String stSearch=etSearch.getText().toString();
        if (stSearch.length()==0)
            etSearch.setError("No Text");
    }
    private void eventHandler(){
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(i);
                dataHandler();
            }
        });

    }
    }

