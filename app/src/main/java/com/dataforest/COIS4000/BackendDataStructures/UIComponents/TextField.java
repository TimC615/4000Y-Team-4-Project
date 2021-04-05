package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import android.content.res.AssetManager;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.StaticMethods;
import com.dataforest.COIS4000.Fragments.InputFields.TextFieldFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextField extends FormAttr<String>{

    public TextField(JSONObject fieldObject, AssetManager assets) throws JSONException {
        init(fieldObject);

        try {
            JSONObject sourcePath = fieldObject.getJSONObject("validation");
            JSONArray tables = sourcePath.getJSONArray("tables");
            String fieldKey = sourcePath.getString("field");
            if (sourcePath != null) {
                JSONObject sourceJSON = StaticMethods.Import(assets, "testFiles/BR0719PGP.json");
                JSONObject currentTable = sourceJSON;
                for (int i = 0; i < tables.length(); i++) {
                    JSONArray currentArr = sourceJSON.optJSONArray("array");
                    if(currentArr != null){
                        int index = findKey(currentArr, tables.getString(i));
                        currentTable = currentArr.getJSONObject(index);
                    }
                    else{
                        currentTable = currentTable.getJSONObject(tables.getString(i));
                    }

                    /*if(current instanceof JSONObject)
                        current = ((JSONObject) current).get(keyMap.getString(i));
                    else if(current instanceof JSONArray){
                        int index = findKey((JSONArray) current, keyMap.getString(i));
                        current = ((JSONArray) current).get(index);
                    }*/
                }

                JSONArray fieldsArray = currentTable.getJSONArray("fields");
                int index = findKey(fieldsArray, fieldKey);
                value = fieldsArray.getJSONObject(index).getString(fieldKey);
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
