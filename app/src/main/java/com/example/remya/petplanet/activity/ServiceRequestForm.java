package com.example.remya.petplanet.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
    TextView location;
    Button button;
    private LocationManager locManager;
    private LocationListener locListener;

    private boolean gps_enabled = false;
    private boolean network_enabled = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        button = (Button) findViewById(R.id.button5);
        location = (TextView)findViewById(R.id.textView29);


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

                Toast.makeText(getBaseContext(),"Your service request has been made!", Toast.LENGTH_LONG).show();

            }


        });

    }

}
