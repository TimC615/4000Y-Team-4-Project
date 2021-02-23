package com.dataforest.COIS4000.Fragments.Forms;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

//maybe should be dialog fragment? (pop-up that pauses parent without actual navigation)
public class TreeRecordFragment extends DialogFragment {
    private Record record;

    private PackageViewModel packageViewModel;

    private View view;
    private int iField;
    private int iForm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tree_record, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        iField = requireArguments().getInt("iField");
        iForm = requireArguments().getInt("iForm");

        record = (Record) packageViewModel.plotPackage.forms[iForm].fields[iField]; //this will get root record

        //next add record to the end of the linked list

        /*put whatever values you want in the bundle
         * there is one bundle for each field name listed above*/

        Bundle[] bundles = new Bundle[record.fields.length];
        for (int i = 1; i < bundles.length; i++){
            bundles[i] = new Bundle();

            //add a value to the bundle as a key-value pair
            //values must be added by type
            bundles[i].putInt("iRecord", iField);
            bundles[i].putInt("iForm", iForm);
            bundles[i].putInt("iField", i);
        }

        /*for every fragment you want to instantiate, add the line:
         * .add(R.id.fragmentContainerId, FragmentClass.class, Bundle or null)
         *
         * Note: this line is not a full statement; without new lines what is below looks like this:
         * getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.field1, record.fields[].getFragmentClass(), bundles[0]).add(R.id.field2, record.fields[].getFragmentClass(), bundles[1]).commit();
         * */

        getChildFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.tree_record_field5, record.fields[1].getFragmentClass(), bundles[1])
                .add(R.id.tree_record_field6, record.fields[2].getFragmentClass(), bundles[2])
                .add(R.id.tree_record_field7, record.fields[3].getFragmentClass(), bundles[3])
                .add(R.id.tree_record_field8, record.fields[4].getFragmentClass(), bundles[4])
                .add(R.id.tree_record_field9, record.fields[5].getFragmentClass(), bundles[5])
                .add(R.id.tree_record_field13, record.fields[6].getFragmentClass(), bundles[6])
                .add(R.id.tree_record_field14, record.fields[7].getFragmentClass(), bundles[7])
                .add(R.id.tree_record_field15, record.fields[8].getFragmentClass(), bundles[8])
                .add(R.id.tree_record_field17, record.fields[9].getFragmentClass(), bundles[9])
                .add(R.id.tree_record_field18, record.fields[10].getFragmentClass(), bundles[10])
                .add(R.id.tree_record_field19, record.fields[11].getFragmentClass(), bundles[11])
                .add(R.id.tree_record_field20, record.fields[12].getFragmentClass(), bundles[12])
                .add(R.id.tree_record_field21, record.fields[13].getFragmentClass(), bundles[13])
                .add(R.id.tree_record_field22, record.fields[14].getFragmentClass(), bundles[14])
                .add(R.id.tree_record_field23, record.fields[15].getFragmentClass(), bundles[15])
                .add(R.id.tree_record_field24, record.fields[16].getFragmentClass(), bundles[16])
                .add(R.id.tree_record_field26, record.fields[17].getFragmentClass(), bundles[17])
                .add(R.id.tree_record_field27, record.fields[18].getFragmentClass(), bundles[18])
                .add(R.id.tree_record_field28, record.fields[19].getFragmentClass(), bundles[19])
                .add(R.id.tree_record_field29, record.fields[20].getFragmentClass(), bundles[20])
                .commit();
    }
}
