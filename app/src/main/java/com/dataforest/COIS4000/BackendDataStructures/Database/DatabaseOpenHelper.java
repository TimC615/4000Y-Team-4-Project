package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOpenHelper extends SQLiteOpenHelper {

    // Database constants
    public static final String DATABASE_NAME = "dbo";
    public static final int DATABASE_VERSION = 1;

    // Internal variables
    Context _context;

    // Constructor
    public DatabaseOpenHelper(Context context) {
        /* Context is passed to the helper
           Name defined in constant
           Factory TBD
           Version defined in constant
        */
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        _context = context;
    }

    // Here the schema is imported and used to define the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        FileSchema schema = new FileSchema();
        String sql = schema.GetSchema(_context);
        if(sql != null) db.execSQL(sql);
    }

    // What to do when the database format needs to be updated
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Delete old database
        if(_context.deleteDatabase(DATABASE_NAME)){
            // Update schema as well?
            // Create new
            onCreate(db);
        }else{
            System.out.println("Failed to delete database. Upgrade aborted.");
        }
    }
}
