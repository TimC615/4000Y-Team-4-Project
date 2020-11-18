package com.dataforest.COIS4000;

// This is a wrapper for a form attribute, adding a title to it.
public class TitledField extends FormAttr{
    Field field;
    String title;

    public TitledField(String title, Field field){
        this.title = title;
        this.field = field;
    }

    public boolean isComplete(){
        return field.isComplete();
    }

    public FormAttr getField(){
        return field;
    }
}
