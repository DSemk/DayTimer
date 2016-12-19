package com.eurotech.samik.daytimer.engine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by samik on 15.12.2016.
 */

public class BaseDataCreator extends SQLiteOpenHelper {
    public static final String DB_NAME_DAYS = "Days_time";
    public static final int DB_DAYS_VERSION = 1;

    public BaseDataCreator(Context context) {
        super(context, DB_NAME_DAYS, null, DB_DAYS_VERSION);
    }

    public static class TodayTable implements BaseColumns {
        public static final String TD_TABLE_NAME = "Today_table";
        public static final String TD_TASK_NAME = "task";
        public static final String TD_TASK_START_TIME = "task_start";
        public static final String TD_TASK_END_TIME = "task_end";
        public static final String TD_TASK_FINAL_TIME = "task_final_time";
    }

    public static class AllDayTable implements BaseColumns {
        public static final String AD_TABLE_NAME = "AllDay_table";
        public static final String AD_TD_TASK_NAME = "task";
        public static final String AD_TD_TASK_ALL_TIME = "task_all_time";
    }

    static String SCRIPT_CREATE_TODAY_TBL = " CREATE TABLE " +
            TodayTable.TD_TABLE_NAME + " ( " +
            TodayTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TodayTable.TD_TASK_NAME + " TEXT," +
            TodayTable.TD_TASK_START_TIME + " TEXT," +
            TodayTable.TD_TASK_END_TIME + " TEXT," +
            TodayTable.TD_TASK_FINAL_TIME + " TEXT," + " ); ";

    static String SCRIPT_CREATE_ALL_DAY_TBL = " CREATE TABLE " +
            AllDayTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            AllDayTable.AD_TABLE_NAME + " TEXT," +
            AllDayTable.AD_TD_TASK_NAME + " TEXT," +
            AllDayTable.AD_TD_TASK_ALL_TIME + " TEXT," + " );";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_CREATE_ALL_DAY_TBL);
        db.execSQL(SCRIPT_CREATE_TODAY_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE " + AllDayTable.AD_TABLE_NAME);
        onCreate(db);
        db.execSQL(" DROP TABLE " + TodayTable.TD_TABLE_NAME);
        onCreate(db);
    }
}
