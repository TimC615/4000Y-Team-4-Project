// Brad Oosterbroek Feb 21 2021
package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;

// Initializes the database object on app startup.
// NOTE: May not be needed depending on the JSON solution and how we decide schemas are updated
public class DatabaseInitializer{

    // Static initialization routine
    public static void InitializeDatabase(Context context){
        Database.SetDatabaseContext(context);
        Database db = Database.GetDatabase();
    }
}
