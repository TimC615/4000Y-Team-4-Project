package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.CodeField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeFieldFragment extends InputFieldFragment<CodeField, Spinner> {

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
    protected boolean isValid() {
        return true;    //temp
    }

    @Override
    protected void updateData() {
        String selected = spinnerAdapter.getItem(input.getSelectedItemPosition());
        formAttr.setValue(selected);
    }

    @Override
    protected void setInputListener() {
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
    }

    @Override
    protected void initInput(View view) {
        input = view.findViewById(inputId);

        List<String> stringList = new ArrayList<>(Arrays.asList(formAttr.values));
        spinnerAdapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, stringList);
        input.setAdapter(spinnerAdapter);

        String value = formAttr.getValue();
        if(value != null){
            int selected = stringList.indexOf(value);
            input.setSelection(selected);
        }
    }
}
