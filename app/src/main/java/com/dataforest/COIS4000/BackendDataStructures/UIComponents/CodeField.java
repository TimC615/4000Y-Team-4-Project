package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.CodeFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class CodeField extends FormAttr {

    public CodeField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        fragmentClass = CodeFieldFragment.class;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

}
