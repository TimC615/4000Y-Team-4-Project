package com.dataforest.COIS4000.Fragments.InputFields;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.FloatField;

public class FloatFieldFragment extends InputFieldFragment {

    EditText input;
    FloatField formAttr;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_number;
        nameId = R.id.numberFieldName;
        inputId = R.id.numberFieldInput;


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        input = view.findViewById(inputId);
        formAttr = (FloatField) getFormAttr();
        input.setOnFocusChangeListener(focusChangeListener);
        Float value = formAttr.getValue();
        if(value != null)
            input.setText(value.toString());
    }


    @Override
    protected boolean isValid() {
        return true;    //temp
    }

    @Override
    protected void updateData() {
            formAttr.setValue(Float.valueOf(input.getText().toString()));
    }
}
