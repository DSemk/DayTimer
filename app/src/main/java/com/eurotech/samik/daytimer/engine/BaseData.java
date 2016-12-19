package com.eurotech.samik.daytimer.engine;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by samik on 26.11.2016.
 */

public class BaseData {
    private static BaseData dataManager;
    private SQLiteDatabase database;
    private BaseDataCreator dbCreator;

    private List<HashMap<String, String>> allDaysData;
    private List<HashMap<String, String>> todayData;

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

    public long insertStartTimeTD(){
        ContentValues contentValues = new ContentValues();


        return database.insert(BaseDataCreator.TodayTable.TD_TABLE_NAME,null,contentValues);
    }

    public long insertEndTimeTD(){
        ContentValues contentValues = new ContentValues();


        return database.insert(BaseDataCreator.TodayTable.TD_TABLE_NAME,null,contentValues);
    }


}
