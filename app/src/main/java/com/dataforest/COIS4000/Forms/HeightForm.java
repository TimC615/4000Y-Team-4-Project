package com.dataforest.COIS4000.Forms;

import com.dataforest.COIS4000.BackendDataStructures.Field;
import com.dataforest.COIS4000.BackendDataStructures.Record;

public class HeightForm extends PlotForm {

    final int numRecordFields = 12;

    public HeightForm(String fileToRead, int numFields){
        super(fileToRead, numFields);  //this handles fields variable

        Field[] recordFields = new Field[numRecordFields];   //these are fields for formatting records
        //declare each record field
        fields[4] = new Record(recordFields);
    }
}
