package com.dataforest.COIS4000.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Forms.TreeForm;

public class TreeRecordActivity extends AppCompatActivity {

    private Record record;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_record);

        try {
            record = (Record) new TreeForm(getAssets(), "jsonFiles/TreeFormConstructor.json").fields[4];    //will probably come up with a better way later
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * the rest if this method is making fragments with parameters
         * if we have a different set of fragments for the record window, this all needs to be done again with thoseXS
         * */
        if(savedInstanceState == null){


            /*put whatever values you want in the bundle
             * there is one bundle for each field name listed above*/

            Bundle[] bundles = new Bundle[record.fields.length];
            for (int i = 1; i < bundles.length; i++){
                bundles[i] = new Bundle();

                //add a value to the bundle as a key-value pair
                //values must be added by type
                bundles[i].putString("name", record.fields[i].name);
                Log.d("kevin", String.valueOf(i));
            }

            /*for every fragment you want to instantiate, add the line:
             * .add(R.id.fragmentContainerId, FragmentClass.class, Bundle or null)
             *
             * Note: this line is not a full statement; without new lines what is below looks like this:
             * getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.field1, record.fields[].getFragmentClass(), bundles[0]).add(R.id.field2, record.fields[].getFragmentClass(), bundles[1]).commit();
             * */

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.tree_record_field5, record.fields[1].getFragmentClass(), bundles[1])
                    .add(R.id.tree_record_field6, record.fields[2].getFragmentClass(), bundles[2])
                    .add(R.id.tree_record_field7, record.fields[3].getFragmentClass(), bundles[3])
                    .add(R.id.tree_record_field8, record.fields[4].getFragmentClass(), bundles[4])
                    .add(R.id.tree_record_field9, record.fields[5].getFragmentClass(), bundles[5])
                    .add(R.id.tree_record_field13, record.fields[6].getFragmentClass(), bundles[6])
                    .add(R.id.tree_record_field14, record.fields[7].getFragmentClass(), bundles[7])
                    .add(R.id.tree_record_field15, record.fields[8].getFragmentClass(), bundles[8])
                    .add(R.id.tree_record_field17, record.fields[9].getFragmentClass(), bundles[9])
                    .add(R.id.tree_record_field18, record.fields[10].getFragmentClass(), bundles[10])
                    .add(R.id.tree_record_field19, record.fields[11].getFragmentClass(), bundles[11])
                    .add(R.id.tree_record_field20, record.fields[12].getFragmentClass(), bundles[12])
                    .add(R.id.tree_record_field21, record.fields[13].getFragmentClass(), bundles[13])
                    .add(R.id.tree_record_field22, record.fields[14].getFragmentClass(), bundles[14])
                    .add(R.id.tree_record_field23, record.fields[15].getFragmentClass(), bundles[15])
                    .add(R.id.tree_record_field24, record.fields[16].getFragmentClass(), bundles[16])
                    .add(R.id.tree_record_field26, record.fields[17].getFragmentClass(), bundles[17])
                    .add(R.id.tree_record_field27, record.fields[18].getFragmentClass(), bundles[18])
                    .add(R.id.tree_record_field28, record.fields[19].getFragmentClass(), bundles[19])
                    .add(R.id.tree_record_field29, record.fields[20].getFragmentClass(), bundles[20])
                    .commit();


            /*there is information on receiving parameters in TextFieldFragment.java
             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */
        }

        Button backToForms = findViewById(R.id.backToForms);
        backToForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   startActivity(new Intent(TreeRecordActivity.this, TreeFormActivity.class));
            }
        });

/*
        Keeping this so we can make fun of Tim.

        Button backToHome = findViewById(R.id.backToHome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TreeRecordActivity.this, TreeFormActivity.class));
            }
        });*/
    }

    public void onButtonShowPopupWindowClick(View view) {
        //taken from the internet (only meant to be here temporarily)

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
