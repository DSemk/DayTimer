package com.eurotech.samik.daytimer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by samik on 25.11.2016.
 */

public class BaseDataManager extends SQLiteOpenHelper {

    private static final String DB_NAME = "days_style";
    private static final int DB_VERSION = 1;

    public  static class DayStyle implements BaseColumns{
        public static final String TABLE_NAME = "days";
        public static final String DAY_NUMBER = "day_number";
        public static final String WORK_TIME = "work";
        public static final String SLEEP_TIME = "sleep";
        public static final String FREE_TIME = "free";

    }


//    private final String SCRIPT = "CREATE "

    public BaseDataManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
