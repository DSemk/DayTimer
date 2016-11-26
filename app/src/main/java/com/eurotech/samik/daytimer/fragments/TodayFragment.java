package com.eurotech.samik.daytimer.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eurotech.samik.daytimer.MainActivity;
import com.eurotech.samik.daytimer.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;


/**
 * Created by samik on 25.11.2016.
 */

public class TodayFragment extends android.app.Fragment {
    private View view;
    private Button addTask;
    private TextView tempTime;
    private RelativeLayout relativeLayout;

    private PieChart mChart;
    private float[] yData = {2, 7, 8, 4, 3};
    private String[] xData = {"Питание", "Сон", "Работа", "Отдых", "Личные дела"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_today, container, false);

        initView();
        initGraph();

        return view;
    }
    private void addData() {
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < yData.length; i++) {
            yVals.add(new Entry(yData[i], i));
        }

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++) {
            xVals.add(xData[i]);
        }

        PieDataSet dataSet = new PieDataSet(yVals, "Сегодня");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15);


        mChart.setData(data);

        mChart.invalidate();
    }
    private void initGraph() {

        mChart = new PieChart(view.getContext());

        relativeLayout.addView(mChart);


        mChart.setUsePercentValues(true);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(5);
        mChart.setTransparentCircleRadius(7);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                if (entry == null) {
                    return;
                }
                Toast.makeText(view.getContext(),
                        xData[entry.getXIndex()] + " - " + entry.getVal() + " ч.",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });


        addData();

        Legend legend = mChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        legend.setXEntrySpace(7);
        legend.setYEntrySpace(5);
    }

    private void initView(){
        addTask = (Button)view.findViewById(R.id.tf_add_task);
        tempTime = (TextView)view.findViewById(R.id.tf_status);
        relativeLayout = (RelativeLayout)view.findViewById(R.id.graph_layout);
    }
}
