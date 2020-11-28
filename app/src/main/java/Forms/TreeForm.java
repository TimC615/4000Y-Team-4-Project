package Forms;

import com.dataforest.BackendDataStructures.Field;
import com.dataforest.BackendDataStructures.Record;

public class TreeForm extends PlotForm {

    final int numRecordFields = 20;

    public TreeForm(String fileToRead, int numFields){
        super(fileToRead, numFields);  //this handles fields variable

        Field[] recordFields = new Field[numRecordFields];   //these are fields for formatting records
        //declare each record field
        fields[4] = new Record(recordFields);
    }
}
