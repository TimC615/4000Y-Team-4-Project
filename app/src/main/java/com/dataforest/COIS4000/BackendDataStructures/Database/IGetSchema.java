package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;

// Interface for implementations of schema retrieval across development
public interface IGetSchema {

    // Returns the schema in a string
    String GetSchema(Context context);
}
