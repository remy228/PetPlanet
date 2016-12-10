package com.example.remya.petplanet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.remya.petplanet.R;

public class WalkPet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_pet2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void startWalking(View view)
    {
        Intent intent = new Intent(this,Walking_Activity.class);
        startActivity(intent);
    }

    public void getWeather(View view)
    {
        Intent intent = new Intent(this,Weather.class);
        startActivity(intent);

    }

}
