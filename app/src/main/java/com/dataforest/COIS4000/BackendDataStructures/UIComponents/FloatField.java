package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;
import com.dataforest.COIS4000.Fragments.InputFields.FloatFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class FloatField extends FormAttr{

    public FloatField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        fragmentClass = FloatFieldFragment.class;
    }
    @Override
    public boolean isComplete() {
        return false;
    }
}
