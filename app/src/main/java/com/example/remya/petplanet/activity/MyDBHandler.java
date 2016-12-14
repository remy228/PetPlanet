package com.example.remya.petplanet.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by remya on 12/6/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PetNanny_3.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "PetsForAdoption";
    public static final String COLUMN_CATEGORY = "Pet_Category";
    public static final String COLUMN_IMAGEURI = "Pet_ImageURI";
    public static final String COLUMN_BREED = "Pet_Breed";
    public static final String COLUMN_CITY = "Pet_City";
    public static final String COLUMN_GENDER = "Pet_Gender";
    public static final String COLUMN_NAME = "Pet_Name";
    public static final String COLUMN_PHONE = "Pet_Owner_Phone";
    public static final String COLUMN_ORGANIZATION = "Pet_Organization";
    public static final String COLUMN_DESCRIPTION = "Pet_Description";


    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_CATEGORY + " TEXT, " + COLUMN_CITY + " TEXT, " + COLUMN_GENDER + " TEXT, " + COLUMN_IMAGEURI + " TEXT, " +
            COLUMN_BREED + " TEXT, " + COLUMN_ORGANIZATION + " TEXT, " + COLUMN_PHONE + " TEXT, " + " TEXT, " + COLUMN_NAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT);";


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS:", "Db has been created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS:", "Table PetsForAdoption has been created");
        Log.i("Tag", CREATE_QUERY);

    }

    public void postPettoDB(String pet_category, String pet_city, String path, String breed, String name, String gender, String phone, String org, String pet_description, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_GENDER, gender);
        contentValues.put(COLUMN_PHONE, phone);
        contentValues.put(COLUMN_ORGANIZATION, org);
        contentValues.put(COLUMN_GENDER, gender);
        contentValues.put(COLUMN_CATEGORY, pet_category);
        contentValues.put(COLUMN_CITY, pet_city);
        contentValues.put(COLUMN_IMAGEURI, path);
        contentValues.put(COLUMN_BREED, breed);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_DESCRIPTION, pet_description);
        db.insert(TABLE_NAME, null, contentValues);
        System.out.println("New values inserted!!!!!!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    /*    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);*/
    }
}

