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

    private int iForm;
    public FormAttr<?>[] fields;
    protected int formType;
    private int requireComplete; //see PlotPackage for possible values
    public String formName;

    public PlotForm(){}

    public PlotForm(AssetManager assets, String fileToRead, int requireComplete, int iForm) throws IOException, JSONException {

        this.requireComplete = requireComplete;

        /*pull field constructor info from external file*/
        JSONObject formObject = StaticMethods.JSONAssetToJSONObject(assets, fileToRead);
        formName = formObject.getString("form-name");
        this.requireComplete = requireComplete;
        this.iForm = iForm;
        formObject = formObject.getJSONObject("fields");
        initializeFieldsFromJSONObject(formObject, assets);
    }

    /*
    * initializes fields with a JSONObject
    * takes the output from StaticMethods.JSONAssetToJSONObject()
    * */
    private void initializeFieldsFromJSONObject(JSONObject formObject, AssetManager assets) throws JSONException {

        //get array of fieldNames
        JSONArray fieldNames = formObject.names();

        //init fields array
        if (fieldNames != null) {
            fields = new FormAttr[fieldNames.length()];


            JSONObject fieldObject;
            String fieldName;

            //get JSONObject for each field
            for (int i = 0; i < fields.length; i++) {
                //get current name
                fieldName = fieldNames.getString(i);

                //get object from name
                fieldObject = formObject.getJSONObject(fieldName);

                //init FormAttr
                fields[i] = constructFieldByType(fieldObject, assets);
            }
        }
    }

    /*
    * accepts a field JSONObject and will return a FormAttr of the corresponding type.
    *
    * */
    public static FormAttr<?> constructFieldByType(JSONObject fieldObject, AssetManager assets) {
        //include a case for each type of field, including records
        //currently basing this off of the UIComponents folder
        try {
            switch (fieldObject.getString("type")) {
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
                    return new CodeField(fieldObject, assets);
                case "Note":
                    return new NoteField(fieldObject);
                case "Record":
                    return new Record(fieldObject, assets);
                default:
                    throw new IllegalArgumentException("Type not recognized");
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean isComplete(){
        for (FormAttr<?> field : fields) {
            if (!field.isComplete()) {
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
        for (FormAttr<?> formAttr : fields) {
            // Pull their JSON
            JSONObject field = formAttr.getJSON();

            // Add the JSON to the fields object
            fieldsJSON.put(formAttr.name, field.get(formAttr.name));
        }

        // Add the field to the record object
        // objectJSON.put(name, fieldsJSON);

        return objectJSON;
    }

    public int getiForm(){
        return iForm;
    }
}
