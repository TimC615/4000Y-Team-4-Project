package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONException;
import org.json.JSONObject;

public class BooleanField extends FormAttr {
    Boolean value;
    Boolean oldValue;

    public BooleanField(JSONObject fieldObject, String fieldName) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldName;
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
