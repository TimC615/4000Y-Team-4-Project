package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.TextFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class TextField extends FormAttr {

    public TextField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        fragmentClass = TextFieldFragment.class;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    public void setValue(String text){ value.setValue(text); }
}
