package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.Fragments.InputFields.NoteFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;


// This looks identical to Text field, what will be the difference?
/* This has a different fragmentClass. The fragment class is used to build the form dynamically. - Kevin*/

public class NoteField extends FormAttr<String>{

    public NoteField(JSONObject fieldObject) throws JSONException{
        init(fieldObject);
        fragmentClass = NoteFieldFragment.class;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    public void setValue(String note){ value = note; }
}
