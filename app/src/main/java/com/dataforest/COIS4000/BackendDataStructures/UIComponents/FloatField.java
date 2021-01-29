package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONException;
import org.json.JSONObject;

public class FloatField extends FormAttr{

    public FloatField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");
    }
    @Override
    public boolean isComplete() {
        return false;
    }
}
