package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// This class pulls an asset schema file and allows access to schema properties
public class AssetFileSchema implements ISchema {

    static String FILE_PATH;

    public AssetFileSchema(String filePath){
        FILE_PATH = filePath;
    }

    @Override
    public String GetSchema(Context context) {

        // Output string
        StringBuilder schema = new StringBuilder();
        // Use to access app assets
        AssetManager assetManager = context.getAssets();
        try {
            // Open schema file into a stream reader
            InputStreamReader isr = new InputStreamReader(assetManager.open(FILE_PATH));
            // Throw that into a buffer
            BufferedReader reader = new BufferedReader(isr);
            // String to hold each line
            String content;
            // Loop through the file taking each line
            while((content = reader.readLine()) != null){
                // Add each line to the string
                schema.append(content);
            }
        } catch (IOException e) {
            // Print the exception and abort
            e.printStackTrace();
            return null;
        }

        return schema.toString();
    }

    @Override
    public ArrayList<String> GetTableSchemas(Context context) {

        // Get the full schema
        ArrayList<String> tableStatements = new ArrayList<String>();
        // Get the full schema
        String schema = GetSchema(context);
        // Split the schema by statements
        String[] statements = schema.split(";");

        // Pull each table statement from the schema
        for(String statement : statements){
            if(statement.startsWith("CREATE")) tableStatements.add(statement);

        }

        return tableStatements;
    }
}
