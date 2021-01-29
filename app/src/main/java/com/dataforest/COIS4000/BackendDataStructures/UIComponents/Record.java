package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Record extends FormAttr {
    FormAttr[] fields;
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
        for(int i = 0; i < fieldNames.length(); i++){
            //get current name
            fieldName = fieldNames.getString(i);

            //get object from name
            fieldObject = recordObject.getJSONObject(fieldName);

            //init FormAttr
            fields[i] = constructFieldByType(fieldObject);
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
}

