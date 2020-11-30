package com.dataforest.COIS4000.Forms;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PlotForm {
    int formId;
    int packageId;
    int formType;
    boolean isComplete;
    FormAttr[] fields;

    /*
    * idea: pass from PlotPackage object, then fill out JSONObject, and send back to PlotPackage
    * */
    JSONObject formJSON;

    public PlotForm(String fileToRead, int numFields){
        /*pull field constructor info from external file*/
        fields = new FormAttr[numFields];
    }

    /*
    * initializes fields with a JSONObject
    * takes the output from StaticMethods.JSONAssetToJSONObject()
    * */
    private void getFieldsFromJSONObject(JSONObject formObject) throws JSONException {

        JSONArray fieldNames = formObject.names();

        JSONObject current;

        fields = new FormAttr[fieldNames.length()];

        //get JSONObject for each field
        for(int i = 0; i < fieldNames.length(); i++){
            current = formObject.getJSONObject(fieldNames.getString(i));
            //check if record
            //if record, call record constructor on JSONObject
            //if not record, call field constructor on JSONObject
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
