package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.CodeFieldFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//not sure if this will actually be a string
public class CodeField extends FormAttr<String> {

    public String[] values;

    public CodeField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);


        JSONArray jsonValues = fieldObject.getJSONArray("values");
        values = new String[jsonValues.length()];

        for(int i = 0; i < jsonValues.length(); i++){
            values[i] = jsonValues.getString(i);
        }
    }

    public CodeField(FormAttr<?> existing){
        init(this, existing);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return CodeFieldFragment.class;
    }

    @Override
    public FormAttr<?> newInstance() {
        CodeField instance =  new CodeField(this);
        instance.values = values.clone();
        return instance;
    }
}
