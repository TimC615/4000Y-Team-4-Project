package com.dataforest.COIS4000.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.dataforest.COIS4000.BackendDataStructures.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button package1 = findViewById(R.id.Package1);
        Button package2 = findViewById(R.id.Package2);
        Button package3 = findViewById(R.id.Package3);

        package1.setOnClickListener(this);
        package2.setOnClickListener(this);
        package3.setOnClickListener(this);


        Button uploadAll = findViewById(R.id.uploadPackages);

        uploadAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(view);
            }
        });
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
            case R.id.Package1:
                //FormNavHost will be the activity to use once it is implemented
                startActivity(new Intent(this, FormNavHost.class));
                break;
            case R.id.Package2:
                Toast.makeText(this, "Package2 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Package3:
                Toast.makeText(this, "Package3 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.AddNewAccumulation:
                Toast.makeText(this, "AddNewAccumulator clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewAssociatedPlot:
                Toast.makeText(this, "AddNewAssociatedPlot clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewAssocPlot:
                Toast.makeText(this, "AddNewAssocPlot clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewCavity:
                Toast.makeText(this, "AddNewCavity clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewContact:
                Toast.makeText(this, "AddNewContact clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewCWD:
                Toast.makeText(this, "AddNewCWD clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewDeformity:
                Toast.makeText(this, "AddNewDeformity clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewDeformityComparison:
                Toast.makeText(this, "AdNewDeformityComparison clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewDistToDir:
                Toast.makeText(this, "AddNewDistToDir clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewDWDLine:
                Toast.makeText(this, "AddNewDWDLine clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewFeaturePhoto:
                Toast.makeText(this, "AddNewFeaturePhoto clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewHeight:
                Toast.makeText(this, "AddNewHeight clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewHeightComparison:
                Toast.makeText(this, "AddNewHeightComparison clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewHorizonAttribute:
                Toast.makeText(this, "AddNewHorizonAttribute clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewMember:
                Toast.makeText(this, "AddNewMmeber clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewMortalityEntry:
                Toast.makeText(this, "AddNewMortalityEntry clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewPackage:
                Toast.makeText(this, "AddNewPackage clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewPlotCompromise:
                Toast.makeText(this, "AddNewPlotCompromise clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewPlotDisturbance:
                Toast.makeText(this, "AddNewPlotDisturbance clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewPlotTreatment:
                Toast.makeText(this, "AddNewPlotTreatment clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewRegenEntry:
                Toast.makeText(this, "AddNewRegenEntry clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewSaplingEntry:
                Toast.makeText(this, "AddNewSaplingEntry clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewStockingEntry:
                Toast.makeText(this, "AddNewStockingEntry clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewTree:
                Toast.makeText(this, "AddNewTree clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewTreeComparison:
                Toast.makeText(this, "AddNewTreeComparison clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AddNewUTMCoord:
                Toast.makeText(this, "AddNewUTMCoord clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}