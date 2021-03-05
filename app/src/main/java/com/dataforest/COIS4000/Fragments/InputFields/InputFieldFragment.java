package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.FormAttr;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

import java.text.Normalizer;

/*
* This class is used to make the input fragments more modular
* anything applicable to all input fields will go here
* */
public abstract class InputFieldFragment extends Fragment {

    //these variables are used to interact with the layout
    @LayoutRes protected int layoutId;  //the xml layout that will be display
    @IdRes protected int nameId;    //id of the TextView that will contain the field name
    @IdRes protected int inputId;   //id of the element that accepts user input
    protected View view;    //used to interact with the layout after fragment creation (maybe unnecessary?)

    //these variables are used to share data
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments
    protected int iField; //the index of this field in the PlotForm
    protected int iForm;  //the index of this form in the PlotPackage
    protected int iRecord;  //the index of the record

    //this will be the primary method of getting data from the UI elements
    //the input element will use this listener
    View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus){
                if(isValid())
                    updateData();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(layoutId, container, false);
        return view;
    }

    /*
    * Automatically called after onCreateView().
    *
    * Sets packageViewModel to the activity PackageViewModel
    * Displays the field name
    * Sets formAttr, which can be used to modify data
    * */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if(savedInstanceState == null){


        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        /*
         * How data will be passed to field fragments:
         *       the form fragment will pass a bundle containing the field index of this fragment,
         *       the bundle will also contain the index of the form in the plot package
         *       the data for this fragment will go into:
         *               packageViewModel.plotPackage.forms[formIndex].fields[fieldIndex]
         *
         *
         * */

        //this gets the text field you want to change
        TextView text = view.findViewById(nameId);

        //get information required to access FormAttr
        iRecord = requireArguments().getInt("iRecord", -1); //defaults to -1
        iField = requireArguments().getInt("iField");
        iForm = requireArguments().getInt("iForm");

        //get field name from plot package
        String name = getFormAttr().name;

        //this sets text
        text.setText(name);
        }
    }

    //returns the FormAttr this field should work with
    //checks if field is part of a record or form
    protected FormAttr<?> getFormAttr(){
        Record record;
        if(iRecord < 0)
            return packageViewModel.plotPackage.forms[iForm].fields[iField];
        else{
            record = (Record) packageViewModel.plotPackage.forms[iForm].fields[iRecord];
            return record.fields[iField];
        }
    }

    //isValid checks for valid input (numeric, between a certain range, etc)
    protected abstract boolean isValid();

    //updateData takes data from the fragment and sends it to the plot form
    protected abstract void updateData();
}
