package com.dataforest.COIS4000.BackendDataStructures.UIComponents;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.Fragments.InputFields.DateFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Date;


public class DateField extends FormAttr<Date>{
    Date oldValue;  //changed from localdate to date for compatibility reasons
    String format;

    public DateField(String format){
        this.format = format;
    }

    public DateField(FormAttr<?> existing){
        init(this, existing);
    }

    public DateField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
    }

    // not initializing ensures that the attribute is only complete once a value is added
    @Override
    public boolean isComplete() {
        return !(value == null);
    }

    @Override
    public Class<? extends Fragment> getFragmentClass() {
        return DateFieldFragment.class;
    }

    @Override
    public FormAttr<?> newInstance() {
        return new DateField(this);
    }

}
