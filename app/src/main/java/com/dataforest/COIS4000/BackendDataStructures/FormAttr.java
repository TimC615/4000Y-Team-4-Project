package com.dataforest.COIS4000.BackendDataStructures;

public abstract class FormAttr{
    void checkFormat(){
        throw new UnsupportedOperationException();
    }

    void checkConsistency(){
        throw new UnsupportedOperationException();
    }

    public abstract boolean isComplete();

}