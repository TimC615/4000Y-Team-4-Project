package com.dataforest.COIS4000.Forms;

import android.content.res.AssetManager;

import org.json.JSONException;

import java.io.IOException;

//might delete this later, right now it's being used for testing purposes - Kevin
public class TreeForm extends PlotForm {

    public TreeForm(AssetManager assets, String fileToRead) throws IOException, JSONException {
        super(assets, fileToRead);
    }
}
