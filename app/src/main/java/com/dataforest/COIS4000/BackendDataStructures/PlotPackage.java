package com.dataforest.COIS4000.BackendDataStructures;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.dataforest.COIS4000.Forms.PlotForm;
import com.dataforest.COIS4000.Forms.TreeForm;

public class PlotPackage {


    /*used for picking correct forms - values should correspond with precedence*/
    public final int EXCLUDE = 0;   //do not include in package
    public final int VALIDATE = 1;  //validate old form
    public final int OPTION = 2;    //include form in package, but do not require completion
    public final int LINK = 3;  //form must be completed on some visit (don't really know how to check this)
    public final int INCLUDE = 4;   //form must be completed

    /*possible values for visitTypeList*/
    private final String LOCATE = "locate";
    private final String ESTAB = "establishment";
    private final String RECON = "reconnaissance";
    private final String REMEASURE = "remeasure";
    private final String PST_TREAT = "post-treatment";
    private final String CORRECT = "correction";
    private final String CONFIRM = "confirmation";
    private final String QA = "quality-assurance";

    /*filepaths for assets*/
    private final String VISIT_TYPES = "jsonFiles/VisitTypes.json";

    HashMap<String, Integer> formValues;    //used to decide if a form must be included based on visit type

    String packageId;
    String plotId;
    boolean isComplete;
    public PlotForm[] forms;
    ArrayList<String> visitTypeList;
    int approach;
    boolean coop;

    JSONObject packageJSON;

    //constructor for testing purposes
    public PlotPackage(AssetManager assets) throws IOException, JSONException {
        //forms = new PlotForm[1];
        //forms[0] = new TreeForm(assets, "jsonFiles/TreeFormConstructor.json");

        //get values for visitTypeList

        //get values for formValues
        getFormValues(assets);

        constructForms();

    }


    public PlotPackage(JSONObject packageObject, String visitTypes, AssetManager assets){

        //store file sent from DB team as data structure
        packageJSON = packageObject;

        //get required forms for visit type
        try {
            getFormValues(assets);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //used to instantiate forms based on the values of formValues
    private void constructForms(){
    }

    /*
    * takes a list of visit types and inits forms array with correct forms
    * */
    private void getFormValues(AssetManager assets) throws IOException, JSONException {

        //get VisitTypes.json from asset
        JSONObject assetJSON = StaticMethods.JSONAssetToJSONObject(assets, VISIT_TYPES);

        /*
        *
        * for now just picking one visit type
        *
        * */

        visitTypeList.add(REMEASURE);   //temporary: visitTypeList will get values from user

        //get array of visit type names
        JSONArray visitNames = assetJSON.names();

        //loop through each visit type
        for(int i = 0; i < visitTypeList.size(); i++){

            //get JSONObject for visit type
            JSONObject visitObject = assetJSON.getJSONObject(visitTypeList.get(i));
            //get form names for visitObject (should always be the same; no hardcoding to make code more modular)
            JSONArray formNames = visitObject.names();

            //loop through each form
            for(int j = 0; j < formNames.length(); j++){

                String currentForm = formNames.getString(j);    //name of current form in JSONObject
                Integer currentValue = formValues.get(currentForm); //value stored for current form

                //store the max value
                if(currentValue != null){
                    Integer max = Math.max(currentValue, visitObject.getInt(currentForm));
                    formValues.put(currentForm, max);
                }
                else{
                    formValues.put(currentForm, visitObject.getInt(currentForm));
                }
            }


        }


    }
}
