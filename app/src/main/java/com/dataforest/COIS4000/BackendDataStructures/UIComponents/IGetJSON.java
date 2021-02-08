package com.dataforest.COIS4000.BackendDataStructures.UIComponents;


import org.json.JSONException;
import org.json.JSONObject;

// Brad Oosterbroek Fec 7th 2021
// Interface for the retrieval of JSON representations of objects
public interface IGetJSON {
    // Returns the JSON representation of the object
    JSONObject getJSON() throws JSONException;
}
