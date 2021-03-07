package com.dataforest.COIS4000.BackendDataStructures;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PlotPackage {


    /*
    Completion Requirements
    used for picking correct forms - values should correspond with precedence
    the highest value between all selected visit types will be used - VISIT_TYPES_FP shows where the values can be found*/

    //currently not being used - will be used when we implement selecting visit types

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
    private final String DEV_TEST = "testing-only";

    /*filepaths for assets*/
    private final String VISIT_TYPES_FP = "jsonFiles/VisitTypes.json";
    private final String FORM_CON_FP = "jsonFiles/FormConstructorFilepaths.json";

    HashMap<String, Integer> formCompValues;    //used to decide if a form must be included based on visit type

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

        //get values for visitTypeList
        visitTypeList = new ArrayList<>();

        //get values for formValues
        formCompValues = new HashMap<>();
        getFormValues(assets);

        Iterator iterator = formCompValues.entrySet().iterator();   //iterator for hashmap

        ArrayList<PlotForm> constructedForms = new ArrayList<>();   //constructed forms go here so that forms array can be sized correctly

        //get json constructor filepaths
        JSONObject fpObject = StaticMethods.JSONAssetToJSONObject(assets, FORM_CON_FP);


        //this code block won't work until there are json constructors for each form
        while(iterator.hasNext()){

            //get next form set
            Map.Entry currentForm = (Map.Entry)iterator.next();

            //get the key
            String currentKey = (String) currentForm.getKey();

            //get the array of filepaths
            JSONArray currentFPArr = fpObject.getJSONArray(currentKey);

            //construct a form for each element in the filepath
            for(int i = 0; i < currentFPArr.length(); i++){
                String fp = currentFPArr.getString(i);
                constructedForms.add(new PlotForm(assets, fp, formCompValues.get(currentKey), i));
            }
        }

        //for testing - use the code block above later
        /*JSONArray currentFPArr = fpObject.getJSONArray("trees"); //will actually iterate through hashmap
        for(int i = 0; i < currentFPArr.length(); i++){
            String fp = currentFPArr.getString(i);
            constructedForms.add(new PlotForm(assets, fp, formCompValues.get("trees"), i));
        }*/

        //convert constructed forms to array
        forms = new PlotForm[constructedForms.size()];
        forms = constructedForms.toArray(forms);
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

        visitTypeList.add(DEV_TEST);

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
