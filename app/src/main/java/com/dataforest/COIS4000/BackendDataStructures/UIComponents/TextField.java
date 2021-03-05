package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.TextFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class TextField extends FormAttr<String>{

    public TextField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
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
