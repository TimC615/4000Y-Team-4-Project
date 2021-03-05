package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.FloatFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class FloatField extends FormAttr<Float> {

    public FloatField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
    }

    public FloatField(FormAttr<?> existing){
        init(this, existing);
    }


    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return FloatFieldFragment.class;
    }

    @Override
    public FormAttr<?> newInstance() {
        return new FloatField(this);
    }
}
