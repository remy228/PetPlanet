package com.example.remya.petplanet.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remya.petplanet.R;

public class PetResults extends AppCompatActivity {

    String category, city, breed;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    Intent recieveIntent = getIntent();
    ImageView pic1,pic2,pic3,pic4,pic5,pic6,pic7,pic8,pic9,pic10;
    TextView name1,name2,name3,name4,name5,name6,name7,name8,name9,name10;
    TextView city1,city2,city3,city4,city5,city6,city7,city8,city9,city10;
    TextView breed1,breed2,breed3,breed4,breed5,breed6,breed7,breed8,breed9,breed10;
    TextView org1,org2,org3,org4,org5,org6,org7,org8,org9,org10;
    TextView phone1,phone2,phone3,phone4,phone5,phone6,phone7,phone8,phone9,phone10;
    TextView gen1,gen2,gen3,gen4,gen5,gen6,gen7,gen8,gen9,gen10;
    Uri myUri;
    String pet_name;
    String pet_gender, pet_org,pet_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Code for implementing Fragments
        Configuration config = getResources().getConfiguration();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LandscapeFragment landscapeFragment = new LandscapeFragment();
            fragmentTransaction.replace(android.R.id.content, landscapeFragment);

        }
        fragmentTransaction.commit();
        //Ends here

        pic1 = (ImageView) findViewById(R.id.imageView5);
        pic2 = (ImageView) findViewById(R.id.imageView20);
        pic3 = (ImageView) findViewById(R.id.imageView27);
        pic4 = (ImageView) findViewById(R.id.imageView34);
        pic5 = (ImageView) findViewById(R.id.imageView41);
        pic6 = (ImageView) findViewById(R.id.imageView48);
        pic7 = (ImageView) findViewById(R.id.imageView55);
        pic8 = (ImageView) findViewById(R.id.imageView62);
        pic9 = (ImageView) findViewById(R.id.imageView69);
        pic10 = (ImageView) findViewById(R.id.imageView76);

        name1 = (TextView) findViewById(R.id.textView12);
        name2 = (TextView) findViewById(R.id.textView21);
        name3 = (TextView) findViewById(R.id.textView28);
        name4 = (TextView) findViewById(R.id.textView35);
        name5 = (TextView) findViewById(R.id.textView42);
        name6 = (TextView) findViewById(R.id.textView49);
        name7 = (TextView) findViewById(R.id.textView56);
        name8 = (TextView) findViewById(R.id.textView63);
        name9 = (TextView) findViewById(R.id.textView70);
        name10 = (TextView) findViewById(R.id.textView77);

        city1 = (TextView) findViewById(R.id.textView15);
        city2 = (TextView) findViewById(R.id.textView25);
        city3 = (TextView) findViewById(R.id.textView32);
        city4 = (TextView) findViewById(R.id.textView39);
        city5 = (TextView) findViewById(R.id.textView46);
        city6 = (TextView) findViewById(R.id.textView53);
        city7 = (TextView) findViewById(R.id.textView60);
        city8 = (TextView) findViewById(R.id.textView67);
        city9 = (TextView) findViewById(R.id.textView74);
        city10 = (TextView) findViewById(R.id.textView81);


        breed1 = (TextView) findViewById(R.id.textView13);
        breed2 = (TextView) findViewById(R.id.textView22);
        breed3 = (TextView) findViewById(R.id.textView29);
        breed4 = (TextView) findViewById(R.id.textView36);
        breed5 = (TextView) findViewById(R.id.textView43);
        breed6 = (TextView) findViewById(R.id.textView50);
        breed7 = (TextView) findViewById(R.id.textView57);
        breed8 = (TextView) findViewById(R.id.textView64);
        breed9 = (TextView) findViewById(R.id.textView71);
        breed10 = (TextView) findViewById(R.id.textView78);


        org1 = (TextView) findViewById(R.id.textView11);
        org2 = (TextView) findViewById(R.id.textView24);
        org3 = (TextView) findViewById(R.id.textView31);
        org4 = (TextView) findViewById(R.id.textView38);
        org5 = (TextView) findViewById(R.id.textView45);
        org6 = (TextView) findViewById(R.id.textView52);
        org7 = (TextView) findViewById(R.id.textView59);
        org8 = (TextView) findViewById(R.id.textView66);
        org9 = (TextView) findViewById(R.id.textView73);
        org10 = (TextView) findViewById(R.id.textView80);

        phone1 = (TextView) findViewById(R.id.textView19);
        phone2 = (TextView) findViewById(R.id.textView26);
        phone3 = (TextView) findViewById(R.id.textView33);
        phone4 = (TextView) findViewById(R.id.textView40);
        phone5 = (TextView) findViewById(R.id.textView47);
        phone6 = (TextView) findViewById(R.id.textView54);
        phone7 = (TextView) findViewById(R.id.textView61);
        phone8 = (TextView) findViewById(R.id.textView68);
        phone9 = (TextView) findViewById(R.id.textView75);
        phone10 = (TextView) findViewById(R.id.textView82);

        gen1 = (TextView) findViewById(R.id.textView17);
        gen2 = (TextView) findViewById(R.id.textView23);
        gen3 = (TextView) findViewById(R.id.textView30);
        gen4 = (TextView) findViewById(R.id.textView37);
        gen5 = (TextView) findViewById(R.id.textView44);
        gen6 = (TextView) findViewById(R.id.textView51);
        gen7 = (TextView) findViewById(R.id.textView58);
        gen8 = (TextView) findViewById(R.id.textView65);
        gen9 = (TextView) findViewById(R.id.textView72);
        gen10 = (TextView) findViewById(R.id.textView79);


        //Recieving values entered for Search results through Intent

        recieveIntent = new Intent(this, GetPet.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            category = extras.getString("category");
            city = extras.getString("city");
            breed = extras.getString("breed");
            System.out.println("Intent test recieved: " + category + " " + city + " " + breed);
        }

        myDBHandler = new MyDBHandler(getApplicationContext());
        sqLiteDatabase = myDBHandler.getReadableDatabase();

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager cm = (ClipboardManager)getBaseContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(phone1.getText());
                Toast.makeText(getBaseContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

       /* myView = findViewById(R.id.view);
        myView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Long Clicked " , Toast.LENGTH_SHORT).show();

                return true;    // set to true
            }
        });*/

      /*  Cursor c=sqLiteDatabase.rawQuery("SELECT Pet_ImageURI, Pet_Name, Pet_Gender, Pet_Organization, Pet_Owner_Phone" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'" , null);
        if(c.moveToFirst()) {
            int curSize=c.getCount();  // return no of rows
            if(curSize>10) {
                int lastTenValue=curSize -10;
                for(int i=0;i<lastTenValue;i++){
                    c.moveToNext();
                }
            } else {
                c.moveToFirst();
            }
        }
*/

        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();
                Cursor cur11 = sqLiteDatabase.rawQuery("SELECT Pet_Description" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'", null);
                try {

                    while (cur11.moveToNext()) {

                        Toast.makeText(getBaseContext(),cur11.getString(cur11.getColumnIndex(MyDBHandler.COLUMN_DESCRIPTION)), Toast.LENGTH_SHORT).show();

                    }
                } finally {
                    cur11.close();
                }
            }
            });

        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();
                Cursor cur11 = sqLiteDatabase.rawQuery("SELECT Pet_Description" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'", null);
                try {

                    while (cur11.moveToNext()) {

                        Toast.makeText(getBaseContext(),cur11.getString(cur11.getColumnIndex(MyDBHandler.COLUMN_DESCRIPTION)), Toast.LENGTH_SHORT).show();

                    }
                } finally {
                    cur11.close();
                }
            }
        });

        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();
                Cursor cur11 = sqLiteDatabase.rawQuery("SELECT Pet_Description" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'", null);
                try {

                    while (cur11.moveToNext()) {

                        Toast.makeText(getBaseContext(),cur11.getString(cur11.getColumnIndex(MyDBHandler.COLUMN_DESCRIPTION)), Toast.LENGTH_SHORT).show();

                    }
                } finally {
                    cur11.close();
                }
            }
        });

        pic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();
                Cursor cur11 = sqLiteDatabase.rawQuery("SELECT Pet_Description" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'", null);
                try {

                    while (cur11.moveToNext()) {

                        Toast.makeText(getBaseContext(),cur11.getString(cur11.getColumnIndex(MyDBHandler.COLUMN_DESCRIPTION)), Toast.LENGTH_SHORT).show();

                    }
                } finally {
                    cur11.close();
                }
            }
        });

        pic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();
                Cursor cur11 = sqLiteDatabase.rawQuery("SELECT Pet_Description" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'", null);
                try {

                    while (cur11.moveToNext()) {

                        Toast.makeText(getBaseContext(),cur11.getString(cur11.getColumnIndex(MyDBHandler.COLUMN_DESCRIPTION)), Toast.LENGTH_SHORT).show();

                    }
                } finally {
                    cur11.close();
                }
            }
        });


        //Retrieve appropriate images and details as results
        int flag = 0;
        Cursor cur1 = sqLiteDatabase.rawQuery("SELECT Pet_ImageURI, Pet_Name, Pet_Gender, Pet_Organization, Pet_Owner_Phone" + " FROM " + MyDBHandler.TABLE_NAME + " where Pet_Category = '" + category + "'" + "AND Pet_Breed = '" + breed + "'" + "AND Pet_City = '" + city + "'", null);
        try {

            while (cur1.moveToNext()){
             /*   int index = cur1.getColumnIndex("rownum");
                System.out.println("Indexxxxxxxxxxxxxxx" + index);*/
                String pet_image = cur1.getString(cur1.getColumnIndex(MyDBHandler.COLUMN_IMAGEURI));
                myUri = Uri.parse(pet_image);
                pet_name = cur1.getString(cur1.getColumnIndex(MyDBHandler.COLUMN_NAME));
                pet_gender = cur1.getString(cur1.getColumnIndex(MyDBHandler.COLUMN_GENDER));
                pet_org = cur1.getString(cur1.getColumnIndex(MyDBHandler.COLUMN_ORGANIZATION));
                pet_phone = cur1.getString(cur1.getColumnIndex(MyDBHandler.COLUMN_PHONE));
                System.out.println("Values:" + pet_name + pet_gender + pet_org + pet_phone);

                if(flag==0){
                    function1();
                }
                  //  function1();
                if(flag==1) {
                    function2();
                }
                if(flag==2) {
                    function2();
                }
                if(flag==3) {
                    function3();
                }
                if(flag==4) {
                    function4();
                }
                if(flag==5) {
                    function5();
                }
                if(flag==6) {
                    function6();
                }
                if(flag==7) {
                    function7();
                }
                if(flag==8) {
                    function8();
                }

                if(flag==9) {
                    function9();
                }

                if(flag==10) {
                    function10();
                }
                flag=flag+1;
            }
        } finally {
            cur1.close();
        }
    }


      public void function1(){
          if (myUri != null) {

                    pic1.setImageURI(myUri);
                }
                if (pet_name != null) {

                    name1.setText(pet_name);
                    breed1.setText(breed);
                    city1.setText(city);
                }

                if (pet_gender != null) {

                    gen1.setText(pet_gender);

                }

                if (pet_org != null) {

                    org1.setText(pet_org);

                }

                if (pet_phone != null) {

                    phone1.setText(pet_phone);

                }
        }

        //2ND

    public void function2(){

                    if (myUri != null) {


                        pic2.setImageURI(myUri);
                    }
                    if (pet_name != null) {

                        name2.setText(pet_name);
                        breed2.setText(breed);
                        city2.setText(city);
                    }

                    if (pet_gender != null) {

                        gen2.setText(pet_gender);

                    }

                    if (pet_org != null) {

                        org2.setText(pet_org);

                    }

                    if (pet_phone != null) {

                        phone2.setText(pet_phone);

                    }

                }


        //3RD

    public void function3(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic3.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name3.setText(pet_name);
                    breed3.setText(breed);
                    city3.setText(city);
                }

                if(pet_gender != null) {

                    gen3.setText(pet_gender);

                }

                if(pet_org != null) {

                    org3.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone3.setText(pet_phone);

                }

            }


        //4TH

    public void function4(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic4.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name4.setText(pet_name);
                    breed4.setText(breed);
                    city4.setText(city);
                }

                if(pet_gender != null) {

                    gen4.setText(pet_gender);

                }

                if(pet_org != null) {

                    org4.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone4.setText(pet_phone);

                }

            }

        //5TH

    public void function5(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic5.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name5.setText(pet_name);
                    breed5.setText(breed);
                    city5.setText(city);
                }

                if(pet_gender != null) {

                    gen5.setText(pet_gender);

                }

                if(pet_org != null) {

                    org5.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone5.setText(pet_phone);

                }

            }


        //6TH

    public void function6(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic6.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name6.setText(pet_name);
                    breed6.setText(breed);
                    city6.setText(city);
                }

                if(pet_gender != null) {

                    gen6.setText(pet_gender);

                }

                if(pet_org != null) {

                    org6.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone6.setText(pet_phone);

                }

            }


        //7TH
        public void function7(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic7.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name7.setText(pet_name);
                    breed7.setText(breed);
                    city7.setText(city);
                }

                if(pet_gender != null) {

                    gen7.setText(pet_gender);

                }

                if(pet_org != null) {

                    org7.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone7.setText(pet_phone);

                }

            }


        //8TH

    public void function8(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic8.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name8.setText(pet_name);
                    breed8.setText(breed);
                    city8.setText(city);
                }

                if(pet_gender != null) {

                    gen8.setText(pet_gender);

                }

                if(pet_org != null) {

                    org8.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone8.setText(pet_phone);

                }

            }
        //9TH
        public void function9(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic9.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name9.setText(pet_name);
                    breed9.setText(breed);
                    city9.setText(city);
                }

                if(pet_gender != null) {

                    gen9.setText(pet_gender);

                }

                if(pet_org != null) {

                    org9.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone9.setText(pet_phone);

                }

            }


        //10TH
        public void function10(){

                if(myUri != null) {

                    //   pic1.setImageURI(null);
                    pic10.setImageURI(myUri);
                }
                if(pet_name != null) {

                    name10.setText(pet_name);
                    breed10.setText(breed);
                    city10.setText(city);
                }

                if(pet_gender != null) {

                    gen10.setText(pet_gender);

                }

                if(pet_org != null) {

                    org10.setText(pet_org);

                }

                if(pet_phone != null) {

                    phone10.setText(pet_phone);

                }

            }



}
