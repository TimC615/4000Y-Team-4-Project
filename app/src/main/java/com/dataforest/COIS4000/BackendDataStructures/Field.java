package com.dataforest.COIS4000.BackendDataStructures;

public class Field extends FormAttr{
    String value;
    String format;
    String oldValue;

    public Field(String format){
        this.format = format;
    }

    @Override
    public boolean isComplete() {
        return !value.isEmpty();
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }
}


