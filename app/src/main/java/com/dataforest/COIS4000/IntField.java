package com.dataforest.COIS4000;

public class IntField extends FormAttr{
    int value;
    int oldValue;
    String format;
    boolean changed = false;

    public IntField(String format){
        this.format = format;
    }

    public IntField(){
        this.format = null;
    }

    // Since ints default to 0 and 0 might be valid, track if the value is ever changed.
    @Override
    public boolean isComplete() {
        return changed;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        changed = true;
        this.value = value;
    }
}
