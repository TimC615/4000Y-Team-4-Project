package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import android.content.res.AssetManager;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.StaticMethods;
import com.dataforest.COIS4000.Fragments.InputFields.TextFieldFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class TextField extends FormAttr<String>{

    public TextField(JSONObject fieldObject, AssetManager assets) throws JSONException {
        init(fieldObject);

        try {
            JSONArray keyMap = fieldObject.optJSONArray("key-map");
            if (keyMap != null) {
                JSONObject sourceJSON = StaticMethods.Import(assets, "testFiles/BR0719PGP.json");
                Object current = sourceJSON;
                for (int i = 0; i < keyMap.length(); i++) {
                    if(current instanceof JSONObject)
                        current = ((JSONObject) current).get(keyMap.getString(i));
                    else if(current instanceof JSONArray){
                        int index = findKey((JSONArray) current, keyMap.getString(i));
                        current = ((JSONArray) current).get(index);
                    }
                }

                String sourceVal = ((JSONObject) current).getString(keyMap.getString(keyMap.length() - 1));
                value = sourceVal;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private int findKey(JSONArray current, String key) throws JSONException {
        for(int i = 0; i < current.length(); i++){
            if(current.getJSONObject(i).has(key))
                return i;
        }
        return -1;
    }

    public TextField(FormAttr<?> existing){
        init(this, existing);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return TextFieldFragment.class;
    }

    @Override
    public FormAttr<?> newInstance() {
        return new TextField(this);
    }
}
