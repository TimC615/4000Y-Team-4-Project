package com.dataforest.COIS4000.Forms;

import android.content.res.AssetManager;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.FormAttr;
import com.dataforest.COIS4000.BackendDataStructures.StaticMethods;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public abstract class PlotForm {
    //formId can be used as an index? (fitting array to required forms vs leaving blank spots in array)
    int formId;
    public FormAttr<?>[] fields;
    protected int formType;


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
        //constructors commented out until we implement them
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
}
