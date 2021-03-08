package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.RecordListFragment;
import com.dataforest.COIS4000.BackendDataStructures.PlotForm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//may need to separate record from FromAttr at some point
public class Record extends FormAttr {
    public FormAttr<?>[] fields;
    private Record next, root;
    private final int METADATA_FIELDS = 2;  //this is the number of objects in the record JSONObject that are not to be converted to FormAttr objects
    private int recordMapKey;

    //used when instantiating form
    public Record(JSONObject recordObject) throws JSONException {

        name = recordObject.getString("name");
        root = this;

        //get array of fieldNames
        JSONArray fieldNames = recordObject.names();

        //init fields array
        if (fieldNames != null) {
            fields = new FormAttr[fieldNames.length() - METADATA_FIELDS];


            String fieldName; //holds values from fieldNames
            JSONObject fieldObject; //holds a child JSONObject

            //get JSONObject for each field
            for (int i = 0; i < fieldNames.length() - METADATA_FIELDS; i++) {
                //get current name
                fieldName = fieldNames.getString(i + METADATA_FIELDS);

                //get object from name
                fieldObject = recordObject.getJSONObject(fieldName);

                //init FormAttr
                fields[i] = PlotForm.constructFieldByType(fieldObject, fieldName);
            }
        }

        recordMapKey = -1;
    }

    //used for linked list
    private Record(FormAttr<?>[] fields, Record root){
        this.fields = new FormAttr[fields.length];

        for(int i = 0; i < fields.length; i++){
            this.fields[i] = fields[i].newInstance();
        }

        this.root = root;
        next = null;
        recordMapKey = -1;
    }

    //call this from RecordListFragment
    public Record addRecord(){
        next = new Record(fields, root);
        return next;
    }

    public boolean isCurrentRecordComplete(){
        for(int i = 0; i < fields.length; i++){
            if(!fields[i].isComplete()){
                return false;
            }
        }
        return true;
    }

    public int Count(){
        Record current = root;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    public int countRemaining(){
        Record current = this.next;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    @Override
    public boolean isComplete() {

        return true;

        /*
        Record current = this.next;

        while(current != null){
            if(!current.isCurrentRecordComplete()){
                return false;
            }
        }

        return isCurrentRecordComplete();*/
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return RecordListFragment.class;
    }

    @Override
    public FormAttr<?> newInstance() {
        return null;
    }

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
        objectJSON.put(name, fieldsJSON);

        return objectJSON;
    }

    public Record getNext(){
        return next;
    }

    public boolean setRecordMapKey(int key){
        if(recordMapKey == -1)
        {
            recordMapKey = key;
            return true;
        }
        return false;
    }

    public int getRecordMapKey(){
        return recordMapKey;
    }
}

