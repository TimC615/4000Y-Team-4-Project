package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;
import com.dataforest.COIS4000.Fragments.InputFields.IntFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class IntField extends FormAttr {
    int value;
    int oldValue;
    String format;
    boolean changed = false;

    public IntField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        fragmentClass = IntFieldFragment.class;
    }

    // Since ints default to 0 and 0 might be valid, track if the value is ever changed.
    @Override
    public boolean isComplete() {
        return changed;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        changed = true;
        this.value = value;
    }
}
