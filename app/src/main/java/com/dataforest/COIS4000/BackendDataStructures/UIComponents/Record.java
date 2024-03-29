package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import android.content.res.AssetManager;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.RecordListFragment;
import com.dataforest.COIS4000.BackendDataStructures.PlotForm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

//may need to separate record from FromAttr at some point
@SuppressWarnings("rawtypes")
public class Record extends FormAttr {
    public FormAttr<?>[] fields;
    private Record next, root;
    private int recordMapKey;

    //used when instantiating form
    public Record(JSONObject recordObject, AssetManager assets) throws JSONException {

        name = recordObject.getString("name");
        root = this;

        recordObject = recordObject.getJSONObject("fields");

        //get array of fieldNames
        JSONArray fieldNames = recordObject.names();

        //init fields array
        if (fieldNames != null) {
            fields = new FormAttr[fieldNames.length()];


            String fieldName; //holds values from fieldNames
            JSONObject fieldObject; //holds a child JSONObject

            //get JSONObject for each field
            for (int i = 0; i < fieldNames.length(); i++) {
                //get current name
                fieldName = fieldNames.getString(i);

                //get object from name
                fieldObject = recordObject.getJSONObject(fieldName);

                //init FormAttr
                fields[i] = PlotForm.constructFieldByType(fieldObject, assets);
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
        for (FormAttr<?> field : fields) {
            if (!field.isComplete()) {
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
        for (FormAttr<?> formAttr : fields) {
            // Pull their JSON
            JSONObject field = formAttr.getJSON();

            // Add the JSON to the fields object
            fieldsJSON.put(formAttr.name, field.get(formAttr.name));
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

