package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

// This class pulls a local schema file on the device and allows access to Schema properties
public class LocalFileSchema implements ISchema{

    static String FILE_PATH;

    public LocalFileSchema(String filePath){
        FILE_PATH = filePath;
    }
    @Override
    public String GetSchema(Context context) {

        // Output string
        StringBuilder schema = new StringBuilder();

        try {
            // Open schema file into a stream reader
            File schemaFile = new File(context.getFilesDir() + "/" + FILE_PATH);
            InputStream inputStream = new FileInputStream(schemaFile);
            InputStreamReader isr = new InputStreamReader(inputStream);
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
