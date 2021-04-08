// Brad Oosterbroek Feb 21 2021
package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

// Interface for implementations of schema retrieval across development
public interface ISchema {

    // Returns the schema in a string
    String GetSchema(Context context);
    ArrayList<String> GetTableSchemas(Context context);
}
