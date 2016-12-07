package com.example.remya.petplanet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public class PostPet extends AppCompatActivity {

    ImageButton button;
    Button submitbutton;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView imageView;
    EditText petBreed;
    EditText petName;
    Spinner category;
    String path;
    EditText description;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        category = (Spinner)findViewById(R.id.spinner);
        button = (ImageButton) findViewById(R.id.photobutton);
        submitbutton = (Button)findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        petBreed = (EditText)findViewById(R.id.breedInput);
        petName = (EditText)findViewById(R.id.nameInput);
        description = (EditText)findViewById(R.id.descriptionInput);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });


        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                /*String value=null;
                int i=0;*/
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                String breed = petBreed.getText().toString();
                String name = petName.getText().toString();
                String pet_description = description.getText().toString();
                String pet_category = category.getSelectedItem().toString();


                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                System.out.println("Post Pet Details:" + pet_category + path + breed + name + pet_description);
                myDBHandler.postPettoDB(pet_category,path,breed,name,pet_description,sqLiteDatabase);
                Toast.makeText(getBaseContext(),"Pet Details Saved!", Toast.LENGTH_LONG).show();
                myDBHandler.close();
            /*    nutritionpageintent.putExtra("Recipe",recipename2);
                startActivity(nutritionpageintent);*/

            }


        });

}


    private void openGallery()
    {
        Log.i("Image add on click","Test works");
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            path = imageUri.toString();
            System.out.println("IMAGE TEST" + path);

        }
    }


}
