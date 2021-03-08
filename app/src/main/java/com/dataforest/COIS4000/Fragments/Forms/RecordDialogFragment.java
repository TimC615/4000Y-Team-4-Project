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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

public class RecordDialogFragment extends DialogFragment {

    protected Record record;
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments

    protected int iForm;
    protected int recordKey;  //the key value of the record in packageViewModel.recordMap

    protected Bundle[] bundles;

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

        iForm = requireArguments().getInt("iForm");
        recordKey = requireArguments().getInt("recordKey");

        record = packageViewModel.recordMap.get(recordKey);

        FragmentTransaction addField = getChildFragmentManager().beginTransaction().setReorderingAllowed(true);

        bundles = new Bundle[record.fields.length];
        for(int i = 0; i < bundles.length; i++){
            bundles[i] = new Bundle();

            bundles[i].putInt("recordKey", recordKey);


            bundles[i].putInt("iForm", iForm);
            bundles[i].putInt("iField", i);
            addField.add(addFragmentContainerView(), record.fields[i].getFragmentClass(), bundles[i]);
        }

        addField.commit();
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

    public RecordDialogFragment newInstance(){
        return new RecordDialogFragment();
    }
}
