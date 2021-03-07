package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.TextField;

public class TextFieldFragment extends InputFieldFragment<TextField, EditText> {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_text;
        nameId = R.id.textFieldName;
        inputId = R.id.textFieldInput;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected boolean isValid() {
        return true;    //temp
    }

    @Override
    protected void updateData() {
        //update the value in formAttr
        formAttr.setValue(input.getText().toString());

        //check validity (maybe at end of form?)
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
        String value = formAttr.getValue();
        if(value != null)
            input.setText(value);
        else
            input.setText("");
    }
}