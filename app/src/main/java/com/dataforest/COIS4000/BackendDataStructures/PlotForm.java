package com.dataforest.COIS4000.BackendDataStructures;

import android.content.res.AssetManager;
import android.util.Log;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.FormAttr;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;

public class PlotForm implements IGetJSON{
    //formId can be used as an index? (fitting array to required forms vs leaving blank spots in array)
    int formId;
    public FormAttr<?>[] fields;
    protected int formType;
    private int requireComplete; //see PlotPackage for possible values


    public PlotForm(){}

    public PlotForm(AssetManager assets, String fileToRead, int requireComplete) throws IOException, JSONException {

        this.requireComplete = requireComplete;

        /*pull field constructor info from external file*/
        JSONObject formObject = StaticMethods.JSONAssetToJSONObject(assets, fileToRead);
        initializeFieldsFromJSONObject(formObject);
    }

    public PlotForm(AssetManager assets, String fileToRead) throws IOException, JSONException {
        /*pull field constructor info from external file*/
        JSONObject formObject = StaticMethods.JSONAssetToJSONObject(assets, fileToRead);
        initializeFieldsFromJSONObject(formObject);
    }

    /*
    * initializes fields with a JSONObject
    * takes the output from StaticMethods.JSONAssetToJSONObject()
    * */
    private void initializeFieldsFromJSONObject(JSONObject formObject) throws JSONException {

        //get array of fieldNames
        JSONArray fieldNames = formObject.names();

        //init fields array
        if (fieldNames != null) {
            fields = new FormAttr[fieldNames.length()];


            JSONObject fieldObject;
            String fieldName;

            //get JSONObject for each field
            for (int i = 0; i < fieldNames.length(); i++) {
                //get current name
                fieldName = fieldNames.getString(i);

                //get object from name
                fieldObject = formObject.getJSONObject(fieldName);

                //init FormAttr
                fields[i] = constructFieldByType(fieldObject, fieldName);
            }
        }
    }

    /*
    * accepts a field JSONObject and will return a FormAttr of the corresponding type.
    *
    * */
    public static FormAttr<?> constructFieldByType(JSONObject fieldObject, String fieldName) throws JSONException {
        //include a case for each type of field, including records
        //currently basing this off of the UIComponents folder
        switch (fieldObject.getString("type")){
            case "Boolean":
                return new BooleanField(fieldObject);
            case "Date":
                return new DateField(fieldObject);
            case "Integer":
                return new IntField(fieldObject);
            case "Text":
                return new TextField(fieldObject);
            case "Float":
                return new FloatField(fieldObject);
            case "Code":
                return new CodeField(fieldObject);
            case "Note":
                return new NoteField(fieldObject);
            case "Record":
                return new Record(fieldObject);
            default:
                throw new IllegalArgumentException("Type not recognized");
        }
    }

    public boolean isComplete(){
        for(int i = 0; i < fields.length; i++){
            if(!fields[i].isComplete()){
                return false;
            }
        }
        return true;
    }

    // Not yet complete. Will need to figure out how we want forms represented in the JSON
    @Override
    public JSONObject getJSON() throws JSONException {
        JSONObject objectJSON = new JSONObject();
        JSONObject fieldsJSON = new JSONObject();

        // Loop through each field
        for(int i = 0; i < fields.length; i++) {
            // Pull their JSON
            JSONObject field = fields[i].getJSON();

            // Add the JSON to the fields object
            fieldsJSON.put(fields[i].name, field.get(fields[i].name));
        }

        // Add the field to the record object
        // objectJSON.put(name, fieldsJSON);

        return objectJSON;
    }
}
