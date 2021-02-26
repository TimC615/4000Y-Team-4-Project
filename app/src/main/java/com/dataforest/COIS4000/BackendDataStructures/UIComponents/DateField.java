package com.dataforest.COIS4000.BackendDataStructures.UIComponents;
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

    public DateField(){

    }

    public DateField(JSONObject fieldObject) throws JSONException {
        init(fieldObject);
        fragmentClass = DateFieldFragment.class;
    }

    // not initializing ensures that the attribute is only complete once a value is added
    @Override
    public boolean isComplete() {
        return !(value == null);
    }

}
