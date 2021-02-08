package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.NoteFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;


// This looks identical to Text field, what will be the difference?
public class NoteField extends FormAttr{


    public NoteField(JSONObject fieldObject) throws JSONException{
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        fragmentClass = NoteFieldFragment.class;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    public void setValue(String note){ value.setValue(note); }
}
