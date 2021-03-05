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

public class DateFieldFragment extends InputFieldFragment {

    EditText input;
    DateField formAttr;
    Date date;

    @SuppressLint("SimpleDateFormat")   //android has built in localization, but this lets us set our own date format
    SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input = view.findViewById(inputId);
        formAttr = (DateField)getFormAttr();
        input.setOnFocusChangeListener(focusChangeListener);
        Date value = formAttr.getValue();
        if(value != null)
            input.setText(format.format(value));
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


}
