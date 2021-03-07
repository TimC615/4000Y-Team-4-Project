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
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.IntField;

public class IntFieldFragment extends InputFieldFragment<IntField, EditText> {
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_number;
        nameId = R.id.numberFieldName;
        inputId = R.id.numberFieldInput;


        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected boolean isValid() {
        return true;    //temp
    }

    @Override
    protected void updateData() {
        formAttr.setValue(Integer.valueOf(input.getText().toString()));
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void initInput(View view) {
        input = view.findViewById(inputId);
        Integer value = formAttr.getValue();
        if(value != null)
            input.setText(value.toString());
        else
            input.setText("");
    }

}
