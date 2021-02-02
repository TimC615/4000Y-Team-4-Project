package com.dataforest.COIS4000.BackendDataStructures;

import android.app.Application;

import com.dataforest.COIS4000.BackendDataStructures.Database.DatabaseInitializer;

public class ApplicationInitializer extends Application {

    @Override
    public void onCreate() {
        // Save context
        super.onCreate();
        // Un comment when database can be made from schema
        //DatabaseInitializer.InitializeDatabase(getApplicationContext());
    }

}
