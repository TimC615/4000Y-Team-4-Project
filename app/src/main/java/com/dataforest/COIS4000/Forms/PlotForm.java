package com.dataforest.COIS4000.Forms;

import android.content.res.AssetManager;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;
import com.dataforest.COIS4000.BackendDataStructures.StaticMethods;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.Normalizer;

public abstract class PlotForm {
    int formId;
    int packageId;
    int formType;
    boolean isComplete;
    public FormAttr[] fields;

    /*
    * idea: pass from PlotPackage object, then fill out JSONObject, and send back to PlotPackage
    * */
    JSONObject formJSON;

    public PlotForm(){}

    public PlotForm(AssetManager assets, String fileToRead) throws IOException, JSONException {
        /*pull field constructor info from external file*/
        JSONObject formObject = StaticMethods.JSONAssetToJSONObject(assets, fileToRead);
        getFieldsFromJSONObject(formObject);
    }

    /*
    * initializes fields with a JSONObject
    * takes the output from StaticMethods.JSONAssetToJSONObject()
    * */
    private void getFieldsFromJSONObject(JSONObject formObject) throws JSONException {

        //get array of fieldNames
        JSONArray fieldNames = formObject.names();

        //init fields array
        fields = new FormAttr[fieldNames.length()];

        JSONObject fieldObject;
        String fieldName;

        //get JSONObject for each field
        for(int i = 0; i < fieldNames.length(); i++){
            //get current name
            fieldName = fieldNames.getString(i);

            //get object from name
            fieldObject = formObject.getJSONObject(fieldName);

            //init FormAttr
            fields[i] = constructFieldByType(fieldObject);
        }
    }

    /*
    * accepts a field JSONObject and will return a FormAttr of the corresponding type.
    *
    * */
    private FormAttr constructFieldByType(JSONObject fieldObject) throws JSONException {
        //include a case for each type of field, including records
        //currently basing this off of the UIComponents folder
        //constructors commented out until we implement them
        switch (fieldObject.getString("type")){
            case "Boolean":
                //return new BooleanField(fieldObject);
            case "Date":
                //return new DateField(fieldObject);
            case "Integer":
                //return new IntField(fieldObject);
            case "Text":
                //return new TextField(fieldObject);
            case "Float":
                //return new FloatField(fieldObject);
            case "Record":
                //I think we were going to make Record accept a JSONObject for the constructor
                //return new Record(fieldObject);
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
}
