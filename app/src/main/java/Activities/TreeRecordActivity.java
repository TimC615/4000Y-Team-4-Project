package Activities;

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

import com.dataforest.BackendDataStructures.R;

public class TreeRecordActivity extends AppCompatActivity {

    //hardcoding values for the prototype
    private final String[] fieldNames = {
            "Section #",
            "Tree #",
            "Tag Type",
            "Tree Species",
            "Tree Origin",
            "Tree Status",
            "Ht to DBH (m)",
            "DBH (cm)",
            "Live Crown Ratio (%)",
            "Crown Class",
            "Crown Position",
            "Crown Light",
            "Ht Tree (Y/N)",
            "Crown Condition",
            "Bark Retention",
            "Wood Condition",
            "Decay Class",
            "Ocular Length (m)",
            "Mort. Cause",
            "Broken Top"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_record);


        /*
         * the rest if this method is making fragments with parameters
         * if we have a different set of fragments for the record window, this all needs to be done again with thoseXS
         * */
        if(savedInstanceState == null){


            /*put whatever values you want in the bundle
             * there is one bundle for each field name listed above*/

            /*
            Bundle[] bundles = new Bundle[fieldNames.length];
            for (int i = 0; i < bundles.length; i++){
                bundles[i] = new Bundle();

                //add a value to the bundle as a key-value pair
                //values must be added by type
                bundles[i].putString("name", fieldNames[i]);
            }

             */

            /*for every fragment you want to instantiate, add the line:
             * .add(R.id.fragmentContainerId, FragmentClass.class, Bundle or null)
             *
             * Note: this line is not a full statement; without new lines what is below looks like this:
             * getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.field1, TextFieldFragment.class, bundles[0]).add(R.id.field2, TextFieldFragment.class, bundles[1]).commit();
             * */

            /*
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.tree_record_field1, TextFieldFragment.class, bundles[0])
                    .add(R.id.tree_record_field2, TextFieldFragment.class, bundles[1])
                    .add(R.id.tree_record_field3, TextFieldFragment.class, bundles[2])
                    .add(R.id.tree_record_field4, TextFieldFragment.class, bundles[3])
                    .add(R.id.tree_record_field5, TextFieldFragment.class, bundles[4])
                    .add(R.id.tree_record_field6, TextFieldFragment.class, bundles[5])
                    .add(R.id.tree_record_field7, TextFieldFragment.class, bundles[6])
                    .add(R.id.tree_record_field8, TextFieldFragment.class, bundles[7])
                    .add(R.id.tree_record_field9, TextFieldFragment.class, bundles[8])
                    .add(R.id.tree_record_field10, TextFieldFragment.class, bundles[9])
                    .add(R.id.tree_record_field11, TextFieldFragment.class, bundles[10])
                    .add(R.id.tree_record_field12, TextFieldFragment.class, bundles[11])
                    .add(R.id.tree_record_field13, TextFieldFragment.class, bundles[12])
                    .add(R.id.tree_record_field14, TextFieldFragment.class, bundles[13])
                    .add(R.id.tree_record_field15, TextFieldFragment.class, bundles[14])
                    .add(R.id.tree_record_field16, TextFieldFragment.class, bundles[15])
                    .add(R.id.tree_record_field17, TextFieldFragment.class, bundles[16])
                    .add(R.id.tree_record_field18, TextFieldFragment.class, bundles[17])
                    .add(R.id.tree_record_field19, TextFieldFragment.class, bundles[18])
                    .add(R.id.tree_record_field20, TextFieldFragment.class, bundles[19])
                    .commit();

             */

            /*there is information on receiving parameters in TextFieldFragment.java
             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */
        }

        Button backToForms = findViewById(R.id.backToForms);
        backToForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(view);
            }
        });

        Button backToHome = findViewById(R.id.backToHome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TreeRecordActivity.this, TreeFormActivity.class));
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
