package com.dataforest.COIS4000.BackendDataStructures;

import android.app.Activity;
import android.content.res.AssetManager;
import android.widget.Button;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Fragments.Forms.FormFragment;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A wrapper class for PlotPackage that allows a singleton PlotPackage to be used by all FormFragments.
 * @see PlotPackage
 * @see FormFragment
 */
public class PackageViewModel extends ViewModel {

    public PlotPackage plotPackage;
    public HashMap<Integer, Record> recordMap;
    private boolean initialized = false;

    /**
     * Use this to instantiate the singleton {@link PlotPackage}. Can only be called once from an instance of {@link PackageViewModel}.
     * @param assets The AssetManager for the app. Call getAssets() from an {@link Activity} instance.
     */
    public void init(AssetManager assets){
        if(!initialized) {
            try {
                plotPackage = new PlotPackage(assets);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            recordMap = new HashMap<>();
            initialized = true;
        }
    }

    /**
     * This is just an easier line of code.
     * @param owner When calling from a Fragment, use requireActivity(). When calling from an Activity, use keyword this.
     * @return The instance of PackageViewModel.
     */
    public static PackageViewModel getInstance(ViewModelStoreOwner owner){
        return new ViewModelProvider(owner).get(PackageViewModel.class);
    }

}
