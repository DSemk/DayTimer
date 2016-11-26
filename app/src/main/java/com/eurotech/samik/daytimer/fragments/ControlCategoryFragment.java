package com.eurotech.samik.daytimer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eurotech.samik.daytimer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlCategoryFragment extends Fragment {


    public ControlCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_control_category, container, false);
    }

}
