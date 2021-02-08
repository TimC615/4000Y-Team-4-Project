package com.dataforest.COIS4000.BackendDataStructures.UIComponents;
import com.dataforest.COIS4000.Fragments.InputFields.DateFieldFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class DateField extends FormAttr{
    LocalDate oldValue;
    String format;

    public DateField(String format){
        this.format = format;
    }

    public DateField(){

    }

    public DateField(JSONObject fieldObject) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        name = fieldObject.getString("name");

        fragmentClass = DateFieldFragment.class;
    }

    // not initializing ensures that the attribute is only complete once a value is added
    @Override
    public boolean isComplete() {
        return !(value.getValue() == null);
    }


    public void setValue(LocalDate date){
        value.setValue(date);
    }

}
