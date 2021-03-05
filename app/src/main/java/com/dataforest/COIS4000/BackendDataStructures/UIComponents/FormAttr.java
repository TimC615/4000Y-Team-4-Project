package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.annotation.NonNull;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.IGetJSON;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class FormAttr<T> implements IGetJSON {

    public String name;    //the text that appears beside the field
    public int fieldNum;   //the field number on the form, pulled from constructor json
    protected T value;

    void checkFormat(){
        throw new UnsupportedOperationException();
    }

    void checkConsistency(){
        throw new UnsupportedOperationException();
    }

    protected FormAttr(){}

    public abstract boolean isComplete();

    //used for setting fragment containers
    public abstract Class<? extends androidx.fragment.app.Fragment> getFragmentClass();

    @Override
    public JSONObject getJSON() throws JSONException {
        JSONObject objectJSON = new JSONObject();
        objectJSON.put(name, value.toString());

        return objectJSON;
    }

    protected void init(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");
    }

    protected void init(FormAttr<?> toInit, FormAttr<?> existing){
        toInit.fieldNum = existing.fieldNum;
        toInit.name = existing.name;
    }

    public void setValue(T value){this.value = value;}

    public T getValue(){
        return value;
    }

    public abstract FormAttr<?> newInstance();
}
