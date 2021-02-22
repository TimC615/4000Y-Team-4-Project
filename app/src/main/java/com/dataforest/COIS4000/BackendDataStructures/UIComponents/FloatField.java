package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.FloatFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class FloatField extends FormAttr<Float> {

    public FloatField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
        fragmentClass = FloatFieldFragment.class;
    }
    @Override
    public boolean isComplete() {
        return false;
    }

}
