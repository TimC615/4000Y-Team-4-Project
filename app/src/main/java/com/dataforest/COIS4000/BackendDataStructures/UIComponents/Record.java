package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;
import com.dataforest.COIS4000.Forms.PlotForm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Record extends FormAttr {
    public FormAttr[] fields;
    Record next, prev;

    //used when instantiating form
    public Record(JSONObject recordObject) throws JSONException {

        //get array of fieldNames
        JSONArray fieldNames = recordObject.names();

        //init fields array
        fields = new FormAttr[fieldNames.length()];

        String fieldName; //holds values from fieldNames
        JSONObject fieldObject; //holds a child JSONObject

        //get JSONObject for each field
        for(int i = 1; i < fieldNames.length(); i++){   //start at 1, because the first object will be type
            //get current name
            fieldName = fieldNames.getString(i);

            //get object from name
            fieldObject = recordObject.getJSONObject(fieldName);

            //init FormAttr
            fields[i] = PlotForm.constructFieldByType(fieldObject, fieldName);
        }
    }



    //used for linked list
    public Record(FormAttr[] fields){
        this.fields = fields;
        next = null;
        prev = null;
    }

    /*
    * record should only be added if the current one is complete
    * */
    public void addRecord(){
        if(!isCurrentRecordComplete()){
            //flag not complete & ask for override
        }

        //only if complete/user overrides incomplete state
        next = new Record(fields);
        next.prev = this;

        //send GUI event for adding a row
    }

    public boolean isCurrentRecordComplete(){
        for(int i = 0; i < fields.length; i++){
            if(!fields[i].isComplete()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isComplete() {
        if(prev != null)
            return false;
        Record current = this.next;

        while(current != null){
            if(!current.isCurrentRecordComplete()){
                return false;
            }
        }

        return isCurrentRecordComplete();
    }
}

