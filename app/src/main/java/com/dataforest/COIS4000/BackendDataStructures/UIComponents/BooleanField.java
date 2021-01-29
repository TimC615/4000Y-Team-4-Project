package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONException;
import org.json.JSONObject;

public class BooleanField extends FormAttr {
    Boolean value;
    Boolean oldValue;

    public BooleanField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        //set fragment class
    }

    // No real way to know if a boolean value is completed as both true and false may be valid.
    @Override
    public boolean isComplete() {
        return true;
    }

    public Boolean getValue(){
        return value;
    }

    public void setValue(Boolean value){
        this.value = value;
    }
}
