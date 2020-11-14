package com.dataforest.COIS4000;

public abstract class PlotForm {
    int formId;
    int packageId;
    int formType;
    boolean isComplete;
    FormAttr[] fields;

    public PlotForm(String fileToRead, int numFields){
        /*pull field constructor info from external file*/
        fields = new FormAttr[numFields];
    }

    public boolean isComplete(){
        for(int i = 0; i < fields.length; i++){
            if(!fields[i].isComplete()){
                return false;
            }
        }
        return true;
    }
}
