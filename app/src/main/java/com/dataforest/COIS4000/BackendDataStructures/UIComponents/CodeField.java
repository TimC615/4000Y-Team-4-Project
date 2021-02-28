package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.CodeFieldFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//not sure if this will actually be a string
public class CodeField extends FormAttr<String> {

    public String[] values;

    public CodeField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
        fragmentClass = CodeFieldFragment.class;


        JSONArray jsonValues = fieldObject.getJSONArray("values");
        values = new String[jsonValues.length()];

        for(int i = 0; i < jsonValues.length(); i++){
            values[i] = jsonValues.getString(i);
        }
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
