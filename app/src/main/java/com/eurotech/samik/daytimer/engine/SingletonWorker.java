package com.eurotech.samik.daytimer.engine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by samik on 25.11.2016.
 */
public class SingletonWorker {

    private ArrayList<String[]> daysList;

    private static SingletonWorker ourInstance = new SingletonWorker();

    public static SingletonWorker getInstance() {
        return ourInstance;
    }

    private SingletonWorker() {
    }

}
