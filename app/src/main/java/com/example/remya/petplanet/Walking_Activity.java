package com.example.remya.petplanet;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.logging.Logger;

public class Walking_Activity extends AppCompatActivity implements SensorEventListener {


    private static ToggleButton startStopButton = null;
    private TextView textView;

    private SensorManager mSensorManager;
    ToggleButton tB;
    private Sensor mStepCounterSensor;

    private Sensor mStepDetectorSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        tB = (ToggleButton) findViewById(R.id.StartStopButton);
        setContentView(R.layout.activity_walking_);
        textView = (TextView) findViewById(R.id.text);

        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

       /* tB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (tB.isChecked()) {

                    //Button is ON
                    Log.i("Toggle button test", "Started");

                } else {    //Button is OFF
                    Log.i("Toggle button test", "Stopped");

                }

            }
        });
*/
    }

    @Override
    public void onSensorChanged (SensorEvent event){
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            value = 2000;
            float distance = (float) (0.0005*value);
            String dist = String.format("%.2f", distance);
            if(distance == 1.00)
            {
                Toast.makeText(this,"Congratulations on Walking a Mile! You have now made a donation to the San Jose Dog Shelter for $2!", Toast.LENGTH_SHORT).show();
            }
            textView.setText("Distance Covered : " + dist + " miles");
        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // For test only. Only allowed value is 1.0 i.e. for step taken
            // textView.setText("Step Detector Detected : " + value);
        }

    }

    @Override
    public void onAccuracyChanged (Sensor sensor,int i){

    }

    protected void onResume() {

        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,

                SensorManager.SENSOR_DELAY_FASTEST);

    }


    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
    }

}



