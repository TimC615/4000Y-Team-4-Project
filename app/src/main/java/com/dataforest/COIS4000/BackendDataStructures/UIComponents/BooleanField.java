package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.BooleanFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class BooleanField extends FormAttr {
    Boolean oldValue;

    public BooleanField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        //set fragment class
        fragmentClass = BooleanFieldFragment.class;
    }

    // No real way to know if a boolean value is completed as both true and false may be valid.
    @Override
    public boolean isComplete() {
        return true;
    }

    public void setValue(Boolean value){
        this.value.setValue(value);
    }

}
