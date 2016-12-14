package com.example.remya.petplanet.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.remya.petplanet.R;

/**
 * Created by remya on 12/10/2016.
 */
public class ServiceRequestForm extends AppCompatActivity {


    public int mYear;
    int mMonth;
    int mDay;
    EditText date;
    EditText time;
    Button button;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    TextView type;
    TextView age;
    TextView specs;
    TextView date_needed;
    TextView time_needed;
    TextView phonenumber;
    TextView email_address;
    TextView location;
    TextView days_needed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        button = (Button) findViewById(R.id.button5);
        type = (TextView)findViewById(R.id.type);
        specs = (TextView)findViewById(R.id.needs);
        age = (TextView)findViewById(R.id.age);
        date_needed = (TextView)findViewById(R.id.date);
        time_needed = (TextView)findViewById(R.id.time);
        days_needed = (TextView)findViewById(R.id.number);
        phonenumber = (TextView)findViewById(R.id.phone);
        email_address = (TextView)findViewById(R.id.email);
        location = (TextView)findViewById(R.id.address);




        date.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                mYear=mcurrentDate.get(Calendar.YEAR);
                mMonth=mcurrentDate.get(Calendar.MONTH);
                mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(ServiceRequestForm.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */

                        date.setText(new StringBuilder().append(selectedday).append("/").append(selectedmonth+1).append("/").append(selectedyear));
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();}
                //date.setText(new StringBuilder().append(mDay).append("/").append(mMonth+1).append("/").append(mYear));}
        });


        time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ServiceRequestForm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        String zone = "";

                        if (Calendar.AM_PM == Calendar.AM)
                            zone = "AM";

                        else if (Calendar.AM_PM == Calendar.PM)
                            zone = "PM";

                       time.setText( selectedHour + ":" + selectedMinute + " "+zone);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                String pet_type = type.getText().toString();
                String pet_age = age.getText().toString();
                String pet_specs = specs.getText().toString();
                String service_date= date_needed.getText().toString();
                String service_time = time_needed.getText().toString();
                String days = days_needed.getText().toString();
                String client_phone = phonenumber.getText().toString();
                String client_email = email_address.getText().toString();
                String client_location = location.getText().toString();
                myDBHandler.postRequest(pet_type,pet_age,pet_specs,service_date,service_time,days,client_phone,client_email,client_location,sqLiteDatabase);
                Toast.makeText(getBaseContext(),"Your service request has been made!", Toast.LENGTH_LONG).show();

            }


        });


    }

}
