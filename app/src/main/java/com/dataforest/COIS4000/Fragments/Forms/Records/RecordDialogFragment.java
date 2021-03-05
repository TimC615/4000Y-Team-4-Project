package com.dataforest.COIS4000.Fragments.Forms.Records;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

public abstract class RecordDialogFragment extends DialogFragment {

    @LayoutRes protected int layoutId;


    protected Record record;
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments

    protected int iForm;
    protected int recordKey;  //the key value of the record in packageViewModel.recordMap

    protected Bundle[] bundles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        iForm = requireArguments().getInt("iForm");
        recordKey = requireArguments().getInt("recordKey");

        record = (Record) packageViewModel.recordMap.get(recordKey);

        bundles = new Bundle[record.fields.length];
        for(int i = 0; i < bundles.length; i++){
            bundles[i] = new Bundle();

            bundles[i].putInt("recordKey", recordKey);
            bundles[i].putInt("iForm", iForm);  //not actually needed(?)
            bundles[i].putInt("iField", i);
        }

    }

    //this will return a new instance the class that extends this
    public abstract RecordDialogFragment newInstance();
}
