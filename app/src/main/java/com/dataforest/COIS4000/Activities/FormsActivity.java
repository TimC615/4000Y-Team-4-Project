package com.dataforest.COIS4000.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.dataforest.COIS4000.BackendDataStructures.R;

public class FormsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forms);

        Button form1 = findViewById(R.id.summary_form);
        Button form2 = findViewById(R.id.plot_notes_form);
        Button form3 = findViewById(R.id.site_permissions_form);
        Button form4 = findViewById(R.id.road_post_location_form);
        Button form5 = findViewById(R.id.walkin_form);
        Button form6 = findViewById(R.id.plot_location_and_layout_form);
        Button form7 = findViewById(R.id.stand_information_form);
        Button form8 = findViewById(R.id.photo_form);
        Button form9 = findViewById(R.id.vegetation_form);
        Button form10 = findViewById(R.id.trees_form);
        Button form11 = findViewById(R.id.deformities_and_cavities_form);
        Button form12 = findViewById(R.id.height_worksheet_form);
        Button form13 = findViewById(R.id.heights_form);
        Button form14 = findViewById(R.id.plot_mapping_form);
        Button form15 = findViewById(R.id.down_woody_debris_form);
        Button form16 = findViewById(R.id.stocking_form);
        Button form17 = findViewById(R.id.mortality_form);
        Button form18 = findViewById(R.id.ages_form);
        Button form19 = findViewById(R.id.test_auger_form);
        Button form20 = findViewById(R.id.soil_description_form);
        Button form21 = findViewById(R.id.soil_site_form);
        Button form22 = findViewById(R.id.trees_self_qa_form);
        Button form23 = findViewById(R.id.deformities_self_qa_form);
        Button form24 = findViewById(R.id.heights_self_qa_form);

        form1.setOnClickListener(this);
        form2.setOnClickListener(this);
        form3.setOnClickListener(this);
        form4.setOnClickListener(this);
        form5.setOnClickListener(this);
        form6.setOnClickListener(this);
        form7.setOnClickListener(this);
        form8.setOnClickListener(this);
        form9.setOnClickListener(this);
        form10.setOnClickListener(this);
        form11.setOnClickListener(this);
        form12.setOnClickListener(this);
        form13.setOnClickListener(this);
        form14.setOnClickListener(this);
        form15.setOnClickListener(this);
        form16.setOnClickListener(this);
        form17.setOnClickListener(this);
        form18.setOnClickListener(this);
        form19.setOnClickListener(this);
        form20.setOnClickListener(this);
        form21.setOnClickListener(this);
        form22.setOnClickListener(this);
        form23.setOnClickListener(this);
        form24.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //testing MainActivity push

        return super.onOptionsItemSelected(item);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.summary_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plot_notes_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.site_permissions_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.road_post_location_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.walkin_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plot_location_and_layout_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stand_information_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.photo_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.vegetation_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trees_form:
                startActivity(new Intent(this, TreeFormActivity.class));
                break;
            case R.id.deformities_and_cavities_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.height_worksheet_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.heights_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.plot_mapping_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stocking_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mortality_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.test_auger_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.soil_description_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.soil_site_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trees_self_qa_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.deformities_self_qa_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.heights_self_qa_form:
                Toast.makeText(this, "This form currently doesn't lead anywhere.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
