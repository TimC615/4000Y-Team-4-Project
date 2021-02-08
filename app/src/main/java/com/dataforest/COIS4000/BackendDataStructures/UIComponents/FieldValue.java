package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import org.json.JSONException;
import org.json.JSONObject;

// Brad Oosterbroek Feb 7th 2021

// This class holds a generic piece of data, representing the value a form attribute holds.
public class FieldValue<T>{

    // The value the Field Value object holds
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
