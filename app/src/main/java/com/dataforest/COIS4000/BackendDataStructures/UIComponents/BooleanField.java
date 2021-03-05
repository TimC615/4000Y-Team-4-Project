package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.BooleanFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class BooleanField extends FormAttr<Boolean>{
    Boolean oldValue;

    public BooleanField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
    }

    public BooleanField(FormAttr<?> existing){
        init(this, existing);
    }

    // No real way to know if a boolean value is completed as both true and false may be valid.
    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return BooleanFieldFragment.class;
    }

    @Override
    public FormAttr<?> newInstance() {
        return new BooleanField(this);
    }

}
