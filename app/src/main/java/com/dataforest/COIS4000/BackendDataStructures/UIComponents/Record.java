package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Forms.PlotForm;
import com.dataforest.COIS4000.Fragments.InputFields.RecordListFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//may need to separate record from FromAttr at some point
public class Record extends FormAttr {
    public FormAttr<?>[] fields;
    Record next, root;
    private final int METADATA_FIELDS = 2;  //this is the number of objects in the record JSONObject that are not to be converted to FormAttr objects

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
    }

    //used for linked list
    private Record(FormAttr<?>[] fields, Record root){
        this.fields = new FormAttr[fields.length];

        for(int i = 0; i < fields.length; i++){
            this.fields[i] = fields[i].newInstance();
        }

        this.root = root;
        next = null;
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
}

