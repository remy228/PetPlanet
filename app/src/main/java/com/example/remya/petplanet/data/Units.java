package com.example.remya.petplanet.data;

import org.json.JSONObject;

/**
 * Created by remya on 12/7/2016.
 */
public class Units implements JSONPopulator {

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }
}