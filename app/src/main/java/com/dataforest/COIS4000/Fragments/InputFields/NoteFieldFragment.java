package com.dataforest.COIS4000.Fragments.InputFields;

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
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.NoteField;

public class NoteFieldFragment extends InputFieldFragment<NoteField, EditText> {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        layoutId = R.layout.input_note;
        nameId = R.id.noteFieldName;
        inputId = R.id.noteFieldInput;


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected boolean isValid() {
        return true;    //user can type whatever they want
    }

    @Override
    protected void updateData() {
        formAttr.setValue(input.getText().toString());
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
