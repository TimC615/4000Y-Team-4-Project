package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Record extends FormAttr {
    FormAttr[] fields;
    Record next, prev;

    //used when instantiating form
    public Record(JSONObject recordObject, String name) throws JSONException {

        this.name = name;

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
            fields[i] = constructFieldByType(fieldObject, fieldName);
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
    private FormAttr constructFieldByType(JSONObject fieldObject, String fieldName) throws JSONException {
        //include a case for each type of field, including records
        //currently basing this off of the UIComponents folder
        //constructors commented out until we implement them
        switch (fieldObject.getString("type")){
            case "Boolean":
                return new BooleanField(fieldObject, fieldName);
            case "Date":
                return new DateField(fieldObject, fieldName);
            case "Integer":
                return new IntField(fieldObject, fieldName);
            case "Text":
                return new TextField(fieldObject, fieldName);
            case "Float":
                return new FloatField(fieldObject, fieldName);
            case "Code":
                return new CodeField(fieldObject, fieldName);
            case "Record":
                //I think we were going to make Record accept a JSONObject for the constructor
                return new Record(fieldObject, fieldName);
            default:
                throw new IllegalArgumentException("Type not recognized: " + fieldObject.getString("type"));
        }
    }

}

