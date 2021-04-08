// Brad Oosterbroek Feb 21 2021
package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

// Singleton Database class. This is used to create and retrieve a database object.
public class Database {

    private static Database _instance = null;
    private static Context _context = null;

    public SQLiteDatabase db;

    private Database(){
        // Use the open helper to create the database;
        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(_context);
        db = databaseOpenHelper.getWritableDatabase();
    }

    // Use this to get the instance of the database
    public static Database GetDatabase(){
        // If not yet made, make a new database and return it
        if(_instance == null) _instance = new Database();
        return _instance;
    }

    // Sets the context of the database. This only needs to be done at application start up.
    public static void SetDatabaseContext(Context context){
        _context = context;
    }
}
