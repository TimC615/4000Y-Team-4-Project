package com.dataforest.COIS4000.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.dataforest.COIS4000.BackendDataStructures.R;

/*
*
* This is going to be the activity driving all form input.
*
* The layout contains a navigation container, which is where the forms will appear.
*
* */
public class FormNavHost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_host_forms);
    }
}