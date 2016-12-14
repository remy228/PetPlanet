package com.example.remya.petplanet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.remya.petplanet.R;

public class PetContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void getServiceForm(View view){

        Intent intent = new Intent(this,ServiceRequestForm.class);
        startActivity(intent);

    }


    public void petDiaries(View view){

        Intent intent = new Intent(this,Pet_Diaries.class);
        startActivity(intent);

    }

}
