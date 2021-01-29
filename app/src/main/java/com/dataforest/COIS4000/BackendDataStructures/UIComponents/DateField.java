package com.dataforest.COIS4000.BackendDataStructures.UIComponents;
import com.dataforest.COIS4000.BackendDataStructures.FormAttr;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class DateField extends FormAttr {
    LocalDate date;
    LocalDate oldValue;
    String format;

    public DateField(String format){
        this.format = format;
    }

    public DateField(){

    }

    public DateField(JSONObject fieldObject, String fieldName) throws JSONException {
        fieldNum = fieldObject.getInt("num");
        this.name = fieldName;
    }

    // not initializing ensures that the attribute is only complete once a value is added
    @Override
    public boolean isComplete() {
        return !(date == null);
    }

    public LocalDate getValue(){
        return date;
    }

    public void setVale(LocalDate value){
        date = value;
    }
}
