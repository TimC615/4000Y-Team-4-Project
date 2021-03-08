package com.dataforest.COIS4000.Fragments.InputFields;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.DateField;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class DateFieldFragment extends InputFieldFragment<DateField, EditText> {

    Date date;

    @SuppressLint("SimpleDateFormat")   //android has built in localization, but this lets us set our own date format
    SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");   //is there an format specified in the manual?

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_date;
        nameId = R.id.dateFieldName;
        inputId = R.id.dateFieldInput;


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected boolean isValid() {
        ParsePosition pos = new ParsePosition(0);
        date = format.parse(input.getText().toString(), pos);
        return(date != null);
    }

    @Override
    protected void updateData() {
        formAttr.setValue(date);
    }

    @Override
    protected void setInputListener() {
        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus && isValid())
                    updateData();
            }
        });
    }

    @Override
    protected void initInput(View view) {
        input = view.findViewById(inputId);
        Date value = formAttr.getValue();
        if(value != null)
            input.setText(format.format(value));
        else
            input.setText(format.format(new Date(System.currentTimeMillis())));
    }


}
