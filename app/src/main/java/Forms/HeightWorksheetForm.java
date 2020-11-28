package Forms;

import com.dataforest.BackendDataStructures.Field;

import Forms.PlotForm;

public class HeightWorksheetForm extends PlotForm {

    /*Main Canopy(field 5) is a list of present species
     * for now I'm making this a record
     * The same is true for Sub Canopy(field 6)*/
    final int numRecordFieldsCanopy = 1;

    /*field 7*/
    final int numRecordFieldsSpecies = 6;

    /*Veterans - no field#*/
    final int getNumRecordFieldsVeterans = 5;

    public HeightWorksheetForm(String fileToRead, int numFields){
        super(fileToRead, numFields);

        Field[] recordFieldsCanopy = new Field[numRecordFieldsCanopy];
        Field[] recordFieldsSpecies = new Field[numRecordFieldsSpecies];
        Field[] recordFieldVeterans = new Field[getNumRecordFieldsVeterans];



        //init records
    }
}