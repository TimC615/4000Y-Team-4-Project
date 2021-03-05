package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.IntFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class IntField extends FormAttr<Integer>{

    int oldValue;
    String format;
    boolean changed = false;

    public IntField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
    }

    public IntField(FormAttr<?> existing){
        init(this, existing);
    }

    // Since ints default to 0 and 0 might be valid, track if the value is ever changed.
    // another option might be to use the built-in Integer class, which is nullable (it's just a wrapper) - Kevin
    @Override
    public boolean isComplete() {
        return changed;
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return IntFieldFragment.class;
    }

    public void setValue(Integer value){
        changed = true;
        super.setValue(value);
    }

    @Override
    public FormAttr<?> newInstance() {
        return new IntField(this);
    }

}
