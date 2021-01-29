package com.dataforest.COIS4000.Forms;

import android.content.res.AssetManager;

import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Field;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

import org.json.JSONException;

import java.io.IOException;

public class TreeForm extends PlotForm {

    public TreeForm(AssetManager assets, String fileToRead) throws IOException, JSONException {
        super(assets, fileToRead);
    }
}
