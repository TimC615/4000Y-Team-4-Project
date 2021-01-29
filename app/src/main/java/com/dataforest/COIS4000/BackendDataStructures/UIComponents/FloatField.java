package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONException;
import org.json.JSONObject;

public class FloatField extends FormAttr{

    public FloatField(JSONObject fieldObject, String fieldName) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        this.name = fieldName;
    }
    @Override
    public boolean isComplete() {
        return false;
    }
}
