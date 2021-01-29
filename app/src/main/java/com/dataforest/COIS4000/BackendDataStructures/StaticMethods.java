package com.dataforest.COIS4000.BackendDataStructures;

/*
* this is a class for any methods we want that do not belong to a particular class
* */

import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticMethods {

    /*
    * this will read a json file from assets and return the JSONObject
    * from any activity, calling getAssets() will return the AssetManager
    * filepath should be the full file path starting at assets
    *       example: "jsonFiles/TreeFormConstructor.json" would find assets/jsonFiles/TreeFormConstructor.json
    *
    * may handle exceptions within method later if appropriate
    * */
    public static JSONObject JSONAssetToJSONObject(AssetManager assets, String filepath) throws IOException, JSONException {
        InputStreamReader isr = new InputStreamReader(assets.open(filepath));
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while(line != null){
            builder.append(line);
            line = reader.readLine();
        }

        JSONObject output = new JSONObject(builder.toString());

        //the first object will just contain all the other objects, so might as well return that one
        output = output.getJSONObject(output.keys().next());

        return output;
    }
}
