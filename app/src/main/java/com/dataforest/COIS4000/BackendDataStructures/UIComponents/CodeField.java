package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import android.content.res.AssetManager;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.StaticMethods;
import com.dataforest.COIS4000.Fragments.InputFields.CodeFieldFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

//not sure if this will actually be a string
public class CodeField extends FormAttr<String> {

    private final String CODE_VALUES_FP = "jsonFiles/CodeValues.json";

    public String[] values;

    public CodeField(JSONObject fieldObject, AssetManager assets) throws JSONException, IOException {
        init(fieldObject);

        String valueKey = fieldObject.getString("values");
        JSONObject valuesObject = StaticMethods.JSONAssetToJSONObject(assets, CODE_VALUES_FP);


        JSONArray jsonValues = valuesObject.getJSONArray(valueKey);
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
