package com.dataforest.COIS4000;

public abstract class PlotForm {
    int formId;
    int packageId;
    int formType;
    boolean isComplete;
    String[] fields;
    String[] fieldFormats;

    void checkFieldFormat(int fieldNum){
        throw new UnsupportedOperationException();
    }

    void compareField(int fieldNum, PlotForm oldForm){
        throw new UnsupportedOperationException();
    }
}
