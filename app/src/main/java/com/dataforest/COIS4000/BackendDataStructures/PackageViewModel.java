package com.dataforest.COIS4000.BackendDataStructures;

import android.content.res.AssetManager;
import android.widget.Button;

import androidx.lifecycle.ViewModel;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
*
* This is where the PlotPackage data structure will go.
* This class can be instantiated in the nav_graph host activity, and then in each fragment, and that will allow each fragment to access the same object.
*
* */
public class PackageViewModel extends ViewModel {

    public PlotPackage plotPackage; //contains the actual data
    public HashMap<Integer, Record> recordMap;  //used to reference records, the integers will be stored in the RecordDialogFragment that is coupled with that record
    public ArrayList<RecordDialogFragment> recordDialogs;

    //this will be used like a constructor, since no constructor will actually be called
    public void init(AssetManager assets){
        try {
            plotPackage = new PlotPackage(assets);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recordMap = new HashMap<>();
        recordDialogs = new ArrayList<>();
    }

}
