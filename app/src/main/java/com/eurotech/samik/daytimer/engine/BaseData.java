package com.eurotech.samik.daytimer.engine;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by samik on 26.11.2016.
 */

public class BaseData {
    private static BaseData dataManager;
    private SQLiteDatabase database;
    private BaseDataCreator dbCreator;

    private HashMap<String,Integer> todayList;
    private HashMap<String,Integer> allDayList;

    private BaseData(Context context) {
        dbCreator = new BaseDataCreator(context);
        if (database == null || !database.isOpen()) {
            database = dbCreator.getWritableDatabase();
        }
    }

    public static BaseData getDataManager(Context context){
        if(dataManager == null){
            dataManager = new BaseData(context);
        }
        return dataManager;
    }

    public long insertTaskTD(String taskName){
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseDataCreator.TodayTable.TD_TABLE_NAME,taskName);

        return database.insert(BaseDataCreator.TodayTable.TD_TABLE_NAME,null,contentValues);
    }

    private HashMap<String,Integer> getAllDayListFromDB(){

        return null;
    }

    private HashMap<String,Integer> getTodayListFromDB(){
       String query = " SELECT " +
               BaseDataCreator.TodayTable._ID + " , " +
               BaseDataCreator.TodayTable.TD_TASK_NAME + " , " +
               BaseDataCreator.TodayTable.TD_TASK_START_TIME + " , " +
               BaseDataCreator.TodayTable.TD_TASK_FINAL_TIME + " FROM " + BaseDataCreator.TodayTable.TD_TABLE_NAME;

        return null;
    }

    private HashMap<String,Integer> parseStringOnInt(HashMap<String,String> bdmap){
        return null;
    }

}
