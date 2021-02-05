package com.dataforest.COIS4000.BackendDataStructures;

import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

import com.dataforest.COIS4000.Forms.PlotForm;
import com.dataforest.COIS4000.Forms.TreeForm;

public class PlotPackage {
    String packageId;
    String plotId;
    boolean isComplete;
    public PlotForm[] forms;
    String visitTypes;
    int approach;
    boolean coop;

    JSONObject packageJSON;

    //constructor for testing purposes
    public PlotPackage(AssetManager assets) throws IOException, JSONException {
        forms = new PlotForm[1];
        forms[0] = new TreeForm(assets, "jsonFiles/TreeFormConstructor.json");
    }

    /*
    * passing the constructor a JSONObject might be good for continuing started plot packages
    *
    * the visitTypes String should come from the user
    * */
    public PlotPackage(JSONObject packageObject, String visitTypes, AssetManager assets){

        //store file sent from DB team as data structure
        packageJSON = packageObject;

        //get required forms for visit type
        try {
            getRequiredForms(visitTypes, assets);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /*
    * takes a list of visit types and inits forms array with correct forms
    * */
    private void getRequiredForms(String visitTypes, AssetManager assets) throws IOException, JSONException {

        //get VisitTypes.json from asset
        JSONObject visitJSON = StaticMethods.JSONAssetToJSONObject(assets, "jsonFiles/VisitTypes.json");

        Iterator<String> typeKeys = visitJSON.keys();

        JSONObject currentType;
        Iterator<String> formKeys;
        String currentTypeName;

        //this will loop through each visit type
        while(typeKeys.hasNext()){

            //get the name of the next visit type
            currentTypeName = typeKeys.next();

            //check if currentTypeName is being used
            if(true/*replace with actual condition*/) {

                //get the JSONObject
                currentType = visitJSON.getJSONObject(currentTypeName);

                formKeys = currentType.keys();

                //loop through each plot element
                while(formKeys.hasNext()){
                    //add plot element to list if required
                }
            }
        }
    }
}
