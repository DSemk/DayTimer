package com.eurotech.samik.daytimer.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eurotech.samik.daytimer.R;

/**
 * Created by samik on 25.11.2016.
 */

public class AboutFragment extends Fragment {
    private final String VERSION = "1.0.4";
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_about,container,false);

        textView = (TextView)view.findViewById(R.id.ca_about);
        String s = " Связатьса с разработчиком : gotoyougoal@gmail.com " +
                "\n\n\n\n\n Версия : " + VERSION;
        textView.setText(s);
        return view;
    }
}
