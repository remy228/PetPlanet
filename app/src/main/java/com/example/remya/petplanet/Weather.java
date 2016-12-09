package com.example.remya.petplanet;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.remya.petplanet.data.Channel;
import com.example.remya.petplanet.data.Item;
import com.example.remya.petplanet.service.WeatherServiceCallback;
import com.example.remya.petplanet.service.YahooWeatherService;

public class Weather extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView locationTextView;
    private TextView conditionTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView)findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView)findViewById(R.id.conditionTextView);
        locationTextView = (TextView)findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        service.refreshWeather("San Jose, CA");

    }


    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_"+item.getCondition().getCode(),null,getPackageName());

      //  @SuppressWarnings("deprecation")
                try {
                    Drawable weatherIconDrawable = getResources().getDrawable(resourceId);
                    weatherIconImageView.setImageDrawable(weatherIconDrawable);
                    temperatureTextView.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
                    conditionTextView.setText(item.getCondition().getDescription());
                    locationTextView.setText(service.getLocation());
                }catch(NullPointerException e){

                }
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this,exception.getMessage(), Toast.LENGTH_LONG).show();


    }
}