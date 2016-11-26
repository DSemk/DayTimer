package com.eurotech.samik.daytimer.engine;

import java.util.ArrayList;

/**
 * Created by samik on 26.11.2016.
 */

public class BaseData {
    private ArrayList<String[]> dayType;


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
        //TODO
    }

    public void saveDayList(){
        //TODO
    }
}
