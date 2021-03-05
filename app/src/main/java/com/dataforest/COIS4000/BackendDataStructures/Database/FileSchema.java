package com.dataforest.COIS4000.BackendDataStructures.Database;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileSchema implements IGetSchema {

    static String FILE_PATH = "DatabaseFiles/schema.sql";

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
            // Loop through the file taking each byte
            while((content = reader.readLine()) != null){
                // Add each as a character to the string
                schema.append(content);
            }
        } catch (IOException e) {
            // Print the exception and abort
            e.printStackTrace();
            return null;
        }

        return "CREATE TABLE COMPANY3(\n" +
                "   ID INT PRIMARY KEY     NOT NULL,\n" +
                "   NAME           TEXT    NOT NULL,\n" +
                "   AGE            INT     NOT NULL,\n" +
                "   ADDRESS        CHAR(50),\n" +
                "   SALARY         REAL    CHECK(SALARY > 0),\n" +
                "MSRDATE DATE CHECK(datepart(SALARY,[msrdate])>=(1900) AND [MsrDate]<=getdate())\n" +
                ");";
    }
}
