package com.dataforest.COIS4000.BackendDataStructures;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class PlotPackage {


    /*
    Completion Requirements
    used for picking correct forms - values should correspond with precedence
    the highest value between all selected visit types will be used - VISIT_TYPES_FP shows where the values can be found*/

    public final static int EXCLUDE = 0;   //do not include in package
    public final static int VALIDATE = 1;  //validate old form
    public final static int OPTION = 2;    //include form in package, but do not require completion
    public final static int LINK = 3;  //form must be completed on some visit (don't really know how to check this)
    public final static int INCLUDE = 4;   //form must be completed

    /*possible values for visitTypeList*/
    public final static String LOCATE = "locate";
    public final static String ESTAB = "establishment";
    public final static String RECON = "reconnaissance";
    public final static String REMEASURE = "remeasure";
    public final static String PST_TREAT = "post-treatment";
    public final static String CORRECT = "correction";
    public final static String CONFIRM = "confirmation";
    public final static String QA = "quality-assurance";
    public final static String DEV_TEST = "testing-only";

    /*filepaths for assets*/
    private final static String VISIT_TYPES_FP = "jsonFiles/VisitTypes.json";
    private final static String FORM_CON_FP = "jsonFiles/FormConstructorFilepaths.json";

    HashMap<String, Integer> formCompValues;    //used to decide if a form must be included based on visit type

    public PlotForm[] forms;
    ArrayList<String> visitTypeList;

    public PlotPackage(AssetManager assets, ArrayList<String> visitTypes) throws IOException, JSONException {

        //get values for visitTypeList
        visitTypeList = visitTypes;

        //get values for formValues
        formCompValues = new HashMap<>();
        getFormValues(assets);

        Iterator<Map.Entry<String, Integer>> iterator = formCompValues.entrySet().iterator();   //iterator for hashmap

        ArrayList<PlotForm> constructedForms = new ArrayList<>();   //constructed forms go here so that forms array can be sized correctly

        //get json constructor filepaths
        JSONObject fpObject = StaticMethods.JSONAssetToJSONObject(assets, FORM_CON_FP);

        while(iterator.hasNext()) {

            //get next form set
            Map.Entry<String, Integer> currentForm = iterator.next();


            //get the key
            String currentKey = currentForm.getKey();

            //get the array of filepaths
            JSONArray currentFPArr = fpObject.getJSONArray(currentKey);

            //construct a form for each element in the filepath
            for (int i = 0; i < currentFPArr.length(); i++) {
                String fp = currentFPArr.getString(i);
                constructedForms.add(new PlotForm(assets, fp, formCompValues.get(currentKey), i));
            }
        }

        //convert constructed forms to array
        forms = new PlotForm[constructedForms.size()];
        forms = constructedForms.toArray(forms);
    }

    //used to instantiate forms based on the values of formValues
    private void constructForm(){
    }

    public int getFormIndex(String formName) {
        for (int i = 0; i < forms.length; i++) {
            if (forms[i].formName.equals(formName))
                return i;
        }
        return -1;
    }

    /*
    * takes a list of visit types and determines the requirements for each form
    * */
    private void getFormValues(AssetManager assets) throws IOException, JSONException {

        //get VisitTypes.json from asset
        JSONObject assetJSON = StaticMethods.JSONAssetToJSONObject(assets, VISIT_TYPES_FP);

        //visitTypeList.add(DEV_TEST);    //for testing - creates a PlotPackage with all forms

        //loop through each visit type
        for(int i = 0; i < visitTypeList.size(); i++){

            //get JSONObject for visit type
            JSONObject visitObject = assetJSON.getJSONObject(visitTypeList.get(i));
            //get form names for visitObject (should always be the same; no hardcoding to make code more modular)
            JSONArray formNames = visitObject.names();

            //loop through each form
            for(int j = 0; j < formNames.length(); j++){

                String currentForm = formNames.getString(j);    //name of current form in JSONObject
                Integer currentValue = formCompValues.get(currentForm); //value stored for current form

                //store the max value
                if(currentValue != null){
                    Integer max = Math.max(currentValue, visitObject.getInt(currentForm));
                    formCompValues.put(currentForm, max);
                }
                else{
                    formCompValues.put(currentForm, visitObject.getInt(currentForm));
                }
            }
        }
    }
}
