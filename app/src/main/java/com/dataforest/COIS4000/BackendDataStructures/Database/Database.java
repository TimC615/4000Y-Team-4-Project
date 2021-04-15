// Brad Oosterbroek Feb 21 2021
package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;

// Singleton Database class. This is used to create and retrieve a database object.
public class Database {

    private static Database _instance = null;
    private static Context _context = null;

    static SQLiteDatabase db;

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

    // Basic template for a transactional insert. The given value is inserted into the given table and field. Transaction events are listened to with the provided listener.
    // How transactional events are handled is delegated to the provided listener.
    public static void TransactionalValidationInsert(String tableName, String fieldName, int value, SQLiteTransactionListener listener){

        // Add the value and field pair to a content value to utilize the insert function
        ContentValues content = new ContentValues();
        content.put(fieldName, value);

        // Pass the db the listener and then try to execute
        db.beginTransactionWithListener(listener);
        try {
            db.insert(tableName, null, content);
        }finally {
            db.endTransaction();
        }
    }
}
