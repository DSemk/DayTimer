package com.eurotech.samik.daytimer.engine;

import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samik on 26.11.2016.
 */

public class BaseData {
    private ArrayList<String[]> dayType;
    private SharedPreferences sharedPreferences;
    private  String strJson;
    public BaseData() {
    }

    public boolean addNewData(String name,String volume){
        for (String[] e : dayType){
            if (e[0].equals(name)){
                return false;
            }
        }

        String[]temp = new String[2];
        temp[0] = name;
        temp[1] = volume;
        return true;
    }

    public void addVolume(String name,String volume){
        for (String[] e : dayType){
            if (e[0].equals(name)){
                e[1] = volume;
            }
        }
    }

    public ArrayList<String[]> getDayType() {
        if (dayType == null){
            initDayList();
        }
        return dayType;
    }

    private void initDayList() {
       strJson = sharedPreferences.getString("jsondata","0");
        if(!strJson.equals("0")) try {
            JSONObject jsonData = new JSONObject(strJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void saveDayList(){
        //TODO
    }

}
class Day{
    List<String[]> dayTask = new ArrayList<>();

    public Day(List<String[]> dayTask) {
        this.dayTask = dayTask;
    }
}
