package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DatabaseOpenHelper extends SQLiteOpenHelper {

    // Database constants
    public static final String DATABASE_NAME = "dbo";
    public static final int DATABASE_VERSION = 1;

    static final String DATABASE_SCHEMA_FILEPATH = "parserTest.sql";
    static final String DATABASE_RAW_SCHEMA_FILEPATH = "DatabaseFiles/table-only.sql";

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
        // Parse the schema file
        SchemaParser parser = new SchemaParser(_context, DATABASE_RAW_SCHEMA_FILEPATH, DATABASE_SCHEMA_FILEPATH);
        // Get the tables from the schema
        ISchema schema = new LocalFileSchema(DATABASE_SCHEMA_FILEPATH);
        ArrayList<String> tableStatements = schema.GetTableSchemas(_context);

        // Add each to the table
        for(String tableStatement : tableStatements){
            if(tableStatement != null) db.execSQL(tableStatement);
            Log.d("yeah", "Table created");
        }

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
