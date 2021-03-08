package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.PlotForm;
import com.dataforest.COIS4000.BackendDataStructures.R;

/**
 *
 */
public class FormFragment extends Fragment {

    protected PackageViewModel packageViewModel;
    protected int iForm;

    protected PlotForm form;

    private LinearLayout fieldList;
    private final LayoutParams FIELD_PARAMS = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        packageViewModel = PackageViewModel.getInstance(requireActivity());
        fieldList = view.findViewById(R.id.FieldList);

        iForm = requireArguments().getInt("iForm", -1);

        //iForm can be passed in a bundle once forms are built dynamically
        if(iForm < 0)
            iForm = packageViewModel.plotPackage.getFormIndex(getFormName());

        form = packageViewModel.plotPackage.forms[iForm];

        Bundle[] bundles = new Bundle[form.fields.length];
        FragmentTransaction addInputFragments = getChildFragmentManager().beginTransaction().setReorderingAllowed(true);

        for(int i = 0; i < bundles.length; i++){
            bundles[i] = new Bundle();
            bundles[i].putInt("iForm", iForm);
            bundles[i].putInt("iField", i);

            addInputFragments.add(addFragmentContainerView(), form.fields[i].getFragmentClass(), bundles[i]);
        }

        addInputFragments.commit();

    }

    /**
     * Get the name of this form. The name will be used to find the index of this form.
     * @return The name of this form as it appears in the form constructor.
     */
    protected String getFormName(){
        return null;
    }

    /**
     * Adds a FragmentContainerView to this record.
     * @return The id of the new FragmentContainerView.
     * @see FragmentContainerView
     */
    @IdRes
    private int addFragmentContainerView(){
        FragmentContainerView fcv = new FragmentContainerView(requireContext());
        fcv.setId(ViewCompat.generateViewId());
        fieldList.addView(fcv, FIELD_PARAMS);
        return fcv.getId();
    }
}
