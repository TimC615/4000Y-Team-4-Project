package com.dataforest.COIS4000.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.TextFieldFragment;

public class CavityRecordActivity extends AppCompatActivity {

    //hardcoding values for the prototype
    private final String[] fieldNames = {
            "Tree #",
            "Old Feed Cav. (\u2713)",
            "New Feed Cav. (\u2713)",
            "Old Nest Cav. (\u2713)",
            "New Nest Cav. (\u2713)",
            "Stick Nest (\u2713)",
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cavities_record);


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
                    .add(R.id.cav_record_field1, TextFieldFragment.class, bundles[0])
                    .add(R.id.cav_record_field2, TextFieldFragment.class, bundles[1])
                    .add(R.id.cav_record_field3, TextFieldFragment.class, bundles[2])
                    .add(R.id.cav_record_field4, TextFieldFragment.class, bundles[3])
                    .add(R.id.cav_record_field5, TextFieldFragment.class, bundles[4])
                    .add(R.id.cav_record_field6, TextFieldFragment.class, bundles[5])
                    .commit();

            /*there is information on receiving parameters in TextFieldFragment.java
             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */
        }

        Button backToHome = findViewById(R.id.cavRecordBack);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CavityRecordActivity.this, TreeFormActivity.class));
            }
        });
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
