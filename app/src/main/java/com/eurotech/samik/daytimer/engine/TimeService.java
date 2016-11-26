package com.eurotech.samik.daytimer.engine;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.HashMap;


import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Chronometer;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by samik on 22.11.2016.
 */

public class TimeService extends IntentService {

    private final int TIME_CONVERT = 3600;
    private HashMap<String, Integer> time;

    private final String HOURS = "hours";
    private final String MINUTES = "minutes";
    private final String SECONDS = "seconds";


    private int hours;
    private int minutes;
    private int seconds;

    private long startPositionTime;
    private long stopPositionTime;
    private long elapsedMillis;

    public TimeService() {
        super("TimeCheckService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        startPositionTime = 0;
        stopPositionTime = 0;
        startRecordingTime();
    }

    public void showFinalTime() {
    }

    public void stopRecordingTime() {
        stopPositionTime = System.currentTimeMillis();
    }

    private void startRecordingTime() {
        startPositionTime = System.currentTimeMillis();
        Log.d("TimeManager", " startRecordingTime() ");
    }

    private void convertData() {
        elapsedMillis = (stopPositionTime - startPositionTime) / 1000;
        hours = (int) elapsedMillis / TIME_CONVERT;
        minutes = (int) (elapsedMillis % TIME_CONVERT) / 60;
        seconds = (int) elapsedMillis % 60;
    }

    public HashMap<String, Integer> showTempTime() {
        convertData();
        stopRecordingTime();
        time = new HashMap<>();
        time.put(HOURS, hours);
        time.put(MINUTES, minutes);
        time.put(SECONDS, seconds);
        Log.d("TimeManager", "showTempTime() ");
        return time;
    }

    public HashMap<String, Integer> getTaskTime() {
        stopRecordingTime();
        convertData();
        time = new HashMap<>();
        time.put(HOURS, hours);
        time.put(MINUTES, minutes);
        time.put(SECONDS, seconds);
        Log.d("TimeManager", "getTaskTime()");
        return time;
    }


}

