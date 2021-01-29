package com.dataforest.COIS4000.BackendDataStructures;

public abstract class FormAttr{

    private Class fragmentClass;    //contains the class type of the fragment this will get data from; set at instantiation
    public String fieldName;    //the text that appears beside the field

    void checkFormat(){
        throw new UnsupportedOperationException();
    }

    void checkConsistency(){
        throw new UnsupportedOperationException();
    }

    public abstract boolean isComplete();

    //used for setting fragment containers
    public Class getFragmentClass(){
        return fragmentClass;
    }

}
