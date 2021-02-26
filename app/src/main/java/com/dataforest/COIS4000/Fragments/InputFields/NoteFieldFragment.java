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

public class NoteFieldFragment extends InputFieldFragment {

    EditText input;
    NoteField formAttr;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        input = view.findViewById(inputId);
        formAttr = (NoteField) getFormAttr();
        input.setOnFocusChangeListener(focusChangeListener);
    }

    @Override
    protected boolean isValid() {
        return true;    //user can type whatever they want
    }

    @Override
    protected void updateData() {
        formAttr.setValue(input.getText().toString());
    }

}
