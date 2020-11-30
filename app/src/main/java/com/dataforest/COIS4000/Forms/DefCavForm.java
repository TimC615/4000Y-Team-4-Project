package com.dataforest.COIS4000.Forms;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Field;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

public class DefCavForm extends PlotForm {

    final int numRecordFields = 20;
    //these 20 fields includes 2 instances of the tree num column
    //as the Def and Cav sections have one instance of it each

    public DefCavForm(String fileToRead, int numFields){
        super(fileToRead, numFields);  //this handles fields variable

        Field[] recordFields = new Field[numRecordFields];   //these are fields for formatting records
        //declare each record field
        fields[3] = new Record(recordFields);
    }
}
