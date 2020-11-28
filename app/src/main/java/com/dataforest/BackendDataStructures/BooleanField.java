package com.dataforest.BackendDataStructures;

public class BooleanField extends FormAttr{
    Boolean value;
    Boolean oldValue;

    // No real way to know if a boolean value is completed as both true and false may be valid.
    @Override
    public boolean isComplete() {
        return true;
    }

    public Boolean getValue(){
        return value;
    }

    public void setValue(Boolean value){
        this.value = value;
    }
}
