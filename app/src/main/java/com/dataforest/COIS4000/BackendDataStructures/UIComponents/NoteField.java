package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.NoteFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class NoteField extends FormAttr<String>{

    public NoteField(JSONObject fieldObject) throws JSONException{
        init(fieldObject);
    }

    public NoteField(FormAttr<?> existing){
        init(this, existing);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return NoteFieldFragment.class;
    }

    public void setValue(String note){ value = note; }

    @Override
    public FormAttr<?> newInstance() {
        return new NoteField(this);
    }
}
