package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.PlotForm;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public abstract class FormFragment extends Fragment {

    protected PackageViewModel packageViewModel;
    protected int iForm;

    protected PlotForm form;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        //commented out as this currently is not being passed
        //iForm = requireArguments().getInt("iForm");

        form = packageViewModel.plotPackage.forms[iForm];

        RecordDialogFragment[] recordTypes = getRecordFragmentInstances();

        packageViewModel.recordDialogs.addAll(Arrays.asList(recordTypes));

        Bundle[] bundles = new Bundle[form.fields.length];
        @IdRes int[] fragmentContainers = getFragmentContainerIds();
        FragmentTransaction addInputFragments = getChildFragmentManager().beginTransaction().setReorderingAllowed(true);

        for(int i = 0, j = 0; i < bundles.length; i++){
            bundles[i] = new Bundle();
            bundles[i].putInt("iForm", iForm);
            bundles[i].putInt("iField", i);

            if(form.fields[i] instanceof Record) {
                bundles[i].putInt("iDialog", packageViewModel.recordDialogs.indexOf(recordTypes[j]));
                j++;
            }

            addInputFragments.add(fragmentContainers[i], form.fields[i].getFragmentClass(), bundles[i]);
        }

        addInputFragments.commit();

    }

    /**
     * @return
     */
    @LayoutRes protected abstract int getLayoutId();

    /**
     *
     * @return An array containing a new instance of each RecordDialogFragment that will appear in this form.
     * If a type of RecordDialogFragment appears multiple times in this form, it must be repeated in the array.
     */
    protected abstract RecordDialogFragment[] getRecordFragmentInstances();

    /**
     *
     * @return An array of ids for FragmentContainers, which will contain fragments for user input.
     */
    @IdRes protected abstract int[] getFragmentContainerIds();
}
