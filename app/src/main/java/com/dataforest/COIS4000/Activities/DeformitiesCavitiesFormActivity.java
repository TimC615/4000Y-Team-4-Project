package com.dataforest.COIS4000.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.TextFieldFragment;

public class DeformitiesCavitiesFormActivity extends AppCompatActivity {

    /*
    !!!!!!!!!!!!
    FIX ALL THIS
    !!!!!!!!!!!!
     */

    //hardcoding values for the prototype
    private final String[] fieldNames = {
            "Plot",
            "Growth Plot Number",
            "Date",
            "Notes"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.def_cav_form);


        /*
         * the rest if this method is making fragments with parameters
         * if we have a different set of fragments for the record window, this all needs to be done again with thoseXS
         * */
        if(savedInstanceState == null){


            /*put whatever values you want in the bundle
             * there is one bundle for each field name listed above*/
            Bundle[] bundles = new Bundle[fieldNames.length];
            for (int i = 0; i < bundles.length; i++){
                bundles[i] = new Bundle();

                //add a value to the bundle as a key-value pair
                //values must be added by type
                bundles[i].putString("name", fieldNames[i]);
            }

            /*for every fragment you want to instantiate, add the line:
             * .add(R.id.fragmentContainerId, FragmentClass.class, Bundle or null)
             *
             * Note: this line is not a full statement; without new lines what is below looks like this:
             * getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.field1, TextFieldFragment.class, bundles[0]).add(R.id.field2, TextFieldFragment.class, bundles[1]).commit();
             * */
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.def_cav_field1, TextFieldFragment.class, bundles[0])
                    .add(R.id.def_cav_field2, TextFieldFragment.class, bundles[1])
                    .add(R.id.def_cav_field3, TextFieldFragment.class, bundles[2])
                    .add(R.id.def_cav_field4, TextFieldFragment.class, bundles[3])
                    .commit();

            /*there is information on receiving parameters in TextFieldFragment.java
             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */
        }

        //FIX THESE - Tim

        /*
        Button addNewDeformity = findViewById(R.id.AddNewDeformity);
        addNewDeformity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(view);
            }
        });

        Button addNewCavity = findViewById(R.id.AddNewCavity);
        addNewCavity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(view);
            }
        });

        Button deformityRecord = findViewById(R.id.deformity_record1);
        deformityRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), DeformityRecordActivity.class));
            }
        });

        Button cavityRecord = findViewById(R.id.cavity_record1);
        cavityRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), CavityRecordActivity.class));
            }
        });

        Button backToForms = findViewById(R.id.defCavBack);
        backToForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeformitiesCavitiesFormActivity.this, FormsActivity.class));
            }
        });

        Button backToHome = findViewById(R.id.defCavBTH);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeformitiesCavitiesFormActivity.this, MainActivity.class));
            }
        });

         */
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