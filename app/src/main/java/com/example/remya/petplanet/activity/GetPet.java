package com.example.remya.petplanet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.remya.petplanet.R;

public class GetPet extends AppCompatActivity {

    String category;
    String city;
    String breed;
    Spinner pet_category;
    Spinner pet_city;
    EditText pet_description;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pet_category = (Spinner)findViewById(R.id.spinner1);
        pet_city = (Spinner)findViewById(R.id.spinner2);
        pet_description = (EditText)findViewById(R.id.descriptionInput);
        search = (Button)findViewById(R.id.button4);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                // TODO Auto-generated method stub
                category = pet_category.getSelectedItem().toString();
                city = pet_city.getSelectedItem().toString();
                breed = pet_description.getText().toString();

                Intent intent = new Intent(GetPet.this, PetResults.class);
                intent.putExtra("category", category);
                intent.putExtra("city", city);
                intent.putExtra("breed", breed);
                System.out.println("Sending intent values for search results: " + category + " " + city + " " + breed);
                startActivity(intent);


            }




    });

}

    public void displayFave(View view){

        Intent intent = new Intent(this,Favorites.class);
        startActivity(intent);

    }
}