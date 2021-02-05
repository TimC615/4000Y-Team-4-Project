package com.dataforest.COIS4000.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;

import org.json.JSONException;

import java.io.IOException;

/*
*
* This is going to be the activity driving all form input.
*
* The layout contains a navigation container, which is where the forms will appear.
*
* */
public class FormNavHost extends AppCompatActivity {

    //this contains the PlotPackage object - it will be accessible from each fragment in scope
    private PackageViewModel packageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_host_forms);

        //adds this activity to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(this).get(PackageViewModel.class);

        try {
            packageViewModel.plotPackage = new PlotPackage(getAssets());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}