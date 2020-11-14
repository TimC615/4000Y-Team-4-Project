package com.dataforest.COIS4000;

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
}


