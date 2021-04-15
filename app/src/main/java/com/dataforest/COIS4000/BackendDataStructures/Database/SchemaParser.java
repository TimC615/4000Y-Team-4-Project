//Brad Oosterbroek April 2 2021
package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Object responsible for transforming a given schema filepath into an SQLite compatible schema
public class SchemaParser {

    // Max number of bytes the given schema can be
    //static final int MAX_SCHEMA_SIZE = 128000;

    public SchemaParser(Context context, String filePath, String outputPath){
        String compatibleSchema = buildSchema(context, filePath);
        Log.d("Schema Parser", compatibleSchema);
        writeToFile(context, compatibleSchema, outputPath);
    }

    // Build the SQLite compatible schema from the schema at the given filepath
    private String buildSchema(Context context, String filePath){
        // Output string that will be turned into the new schema
        StringBuilder schema = new StringBuilder();
        // Use to access app assets
        AssetManager assetManager = context.getAssets();

        try {
            Log.d("Schema Parser", "File opening");
            // Open schema file into a stream reader
            // Since the input files are 16 bit encoded, need to use UTF-16 as opposed to the default UTF-8
            InputStreamReader isr = new InputStreamReader(assetManager.open(filePath), "UTF-16LE");
            BufferedReader reader = new BufferedReader(isr);
            Log.d("Schema Parser", "File Opened");
            // String to hold each line
            String content = null;

            // Loop through the file taking each line
            while((content = reader.readLine()) != null){
                // New table
                if(content.startsWith("CREATE")){
                    Log.d("Schema Parser", "Making a new table");
                    // Add the table to the string builder
                   addTableToSchema(content, reader, schema);
                }
            }
        } catch (IOException e) {
            // Print the exception and abort
            e.printStackTrace();
            return null;
        }
        return schema.toString();
    }

    // Writes the given string to a new file at the output path.
    private void writeToFile(Context context, String compatibleSchema, String outputPath) {
        try{
            // Open or create a file at the given path to write to

            File directory = new File(context.getFilesDir().toString());
            File outFile = new File (directory, outputPath);
            FileOutputStream outStream  = new FileOutputStream(outFile);
            Log.d("Schema Parser", outFile.getAbsolutePath());
            OutputStreamWriter outWriter = new OutputStreamWriter(outStream);

            // Write the file.
            outWriter.write(compatibleSchema);
            outWriter.close();
            Log.d("Schema Parser", "Schema created");
        } catch (IOException e) {
            // Print the exception and abort
            e.printStackTrace();
        }
    }

    private void addTableToSchema(String content, BufferedReader reader, StringBuilder schema) throws IOException {
        // Get everything after the period and add it to the schema
        String[] split = content.split("\\.");
        String tableName = split[1];
        schema.append("CREATE TABLE " + tableName);

        // Loop until we hit "GO"
        while(!(content = reader.readLine()).contains("GO")){
            // Special cases

            Log.d("Schema Parser", content);
            // Non clustered values
            if(content.contains("NONCLUSTERED")){
                // Get everything but the word nonclustered

                schema.append(content.split("NONCLUSTERED")[0]);
            }
            // Clustered values
            else if(content.contains("CLUSTERED")){
                // Get everything but the word clustered
                schema.append(content.split("CLUSTERED")[0]);
            }
            // With lines. The with isn't compatible
            else if (content.contains(")WITH")){
                // Splitting the content here because sometimes there's a comma, but on the last value there isn't
                split = content.split("]");
                // If we detect a comma
                if(split.length == 2){
                    schema.append(")" + split[1]);
                }else{
                    schema.append(")");
                }

            }
            // This is always the last line. The value occurs in the ")WITH" line but we already dealt with that case.
            else if(content.contains(") ON [PRIMARY]")){
                schema.append(");");
            }
            else{
                // In all other cases, add the line in it's entirety
                schema.append(content);
            }
        }
    }
}
