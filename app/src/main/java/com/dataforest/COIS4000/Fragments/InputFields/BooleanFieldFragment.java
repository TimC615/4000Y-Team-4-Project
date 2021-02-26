package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.BooleanField;

public class BooleanFieldFragment extends InputFieldFragment {

    CheckBox input;
    BooleanField formAttr;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_checkbox;
        nameId = R.id.boolFieldName;
        inputId = R.id.boolFieldInput;


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        input = view.findViewById(inputId);
        formAttr = (BooleanField) getFormAttr();
        input.setOnFocusChangeListener(focusChangeListener);
    }

    @Override
    protected boolean isValid() {
        return true;    //temp(?)
    }

    @Override
    protected void updateData() {
        formAttr.setValue(input.isChecked());
    }
}
