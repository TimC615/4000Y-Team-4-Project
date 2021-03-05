package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.CodeField;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeFieldFragment extends InputFieldFragment {

    CodeField formAttr;

    Spinner input;

    ArrayAdapter<String> spinnerAdapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_code;
        nameId = R.id.codeFieldName;
        inputId = R.id.codeFieldInput;


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input = view.findViewById(inputId);
        formAttr = (CodeField) getFormAttr();
        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isValid()){
                    updateData();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> stringList = new ArrayList<>(Arrays.asList(formAttr.values));
        spinnerAdapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, stringList);
        input.setAdapter(spinnerAdapter);

        String value = formAttr.getValue();
        if(value != null){
            int selected = stringList.indexOf(value);
            input.setSelection(selected);
        }
    }

    @Override
    protected boolean isValid() {
        return true;    //temp
    }

    @Override
    protected void updateData() {

        String selected = spinnerAdapter.getItem(input.getSelectedItemPosition());
        formAttr.setValue(selected);
    }
}
