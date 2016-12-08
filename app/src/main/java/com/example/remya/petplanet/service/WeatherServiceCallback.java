package com.example.remya.petplanet.service;

import com.example.remya.petplanet.data.Channel;

/**
 * Created by remya on 12/7/2016.
 */
public interface WeatherServiceCallback {

    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
