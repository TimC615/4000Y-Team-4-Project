package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.IGetJSON;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class FormAttr<T> implements IGetJSON {

    protected Class<? extends androidx.fragment.app.Fragment> fragmentClass;    //contains the class type of the fragment this will get data from; set at instantiation
    public String name;    //the text that appears beside the field
    public int fieldNum;   //the field number on the form, pulled from constructor json
    FieldValue<T> value;

    void checkFormat(){
        throw new UnsupportedOperationException();
    }

    void checkConsistency(){
        throw new UnsupportedOperationException();
    }

    public abstract boolean isComplete();

    //used for setting fragment containers
    public Class<? extends androidx.fragment.app.Fragment> getFragmentClass(){
        return fragmentClass;
    }

    @Override
    public JSONObject getJSON() throws JSONException {
        JSONObject objectJSON = new JSONObject();
        objectJSON.put(name, value.toString());

        return objectJSON;
    }
}
