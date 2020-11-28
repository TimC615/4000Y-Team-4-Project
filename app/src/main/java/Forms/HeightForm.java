package Forms;

import com.dataforest.BackendDataStructures.Field;
import com.dataforest.BackendDataStructures.Record;

import Forms.PlotForm;

public class HeightForm extends PlotForm {

    final int numRecordFields = 12;

    public HeightForm(String fileToRead, int numFields){
        super(fileToRead, numFields);  //this handles fields variable

        Field[] recordFields = new Field[numRecordFields];   //these are fields for formatting records
        //declare each record field
        fields[4] = new Record(recordFields);
    }
}
