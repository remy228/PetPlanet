package com.example.remya.petplanet.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remya.petplanet.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pet_Diaries extends AppCompatActivity {

    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;
    TextView filecontent;
    String FILENAME = "mypetdiaries.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet__diaries);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textmsg=(EditText)findViewById(R.id.editText1);
        filecontent = (TextView)findViewById(R.id.textView18);


        // Create a new output file stream
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the error here
        }

        // Create a new file input stream.
        try {
            FileInputStream fileis = openFileInput(FILENAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mypetdiaries.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file
        try {
            FileInputStream fileIn = openFileInput("mypetdiaries.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = InputRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s += readstring;
            }
            InputRead.close();
            filecontent.setText(s);
            Toast.makeText(getBaseContext(), "File content retrieved!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
