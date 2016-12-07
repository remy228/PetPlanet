package com.example.remya.petplanet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by remya on 12/6/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PetPlanet.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "PetsForAdoption";
    public static final String COLUMN_CATEGORY = "Pet_Category";
    public static final String COLUMN_IMAGEURI = "Pet_ImageURI";
    public static final String COLUMN_BREED = "Pet_Breed";
    public static final String COLUMN_NAME = "Pet_Name";
    public static final String COLUMN_DESCRIPTION = "Pet_Description";

    private static final String CREATE_QUERY = "CREATE TABLE "+ TABLE_NAME + "(" + COLUMN_CATEGORY + " TEXT, " + COLUMN_IMAGEURI + " TEXT, " +
            COLUMN_BREED + " TEXT, " + COLUMN_NAME + " TEXT, "  + COLUMN_DESCRIPTION + " TEXT);" ;


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS:" , "Db has been created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS:", "Table PetsForAdoption has been created");
        Log.i("Tag", CREATE_QUERY);

    }

    public void postPettoDB(String pet_category,String path,String breed,String name,String pet_description, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CATEGORY,pet_category);
        contentValues.put(COLUMN_IMAGEURI,path);
        contentValues.put(COLUMN_BREED,breed);
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_DESCRIPTION,pet_description);
        db.insert(TABLE_NAME,null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
