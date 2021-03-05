package com.dataforest.COIS4000.Fragments.Forms.Records;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;


public class TreeRecordFragment extends RecordDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutId = R.layout.tree_record;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*for every fragment you want to instantiate, add the line:
         * .add(R.id.fragmentContainerId, FragmentClass.class, Bundle or null)
         *
         * Note: this line is not a full statement; without new lines what is below looks like this:
         * getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.field1, record.fields[].getFragmentClass(), bundles[0]).add(R.id.field2, record.fields[].getFragmentClass(), bundles[1]).commit();
         * */

        getChildFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.tree_record_field5, record.fields[0].getFragmentClass(), bundles[0])
                .add(R.id.tree_record_field6, record.fields[1].getFragmentClass(), bundles[1])
                .add(R.id.tree_record_field7, record.fields[2].getFragmentClass(), bundles[2])
                .add(R.id.tree_record_field8, record.fields[3].getFragmentClass(), bundles[3])
                .add(R.id.tree_record_field9, record.fields[4].getFragmentClass(), bundles[4])
                .add(R.id.tree_record_field13, record.fields[5].getFragmentClass(), bundles[5])
                .add(R.id.tree_record_field14, record.fields[6].getFragmentClass(), bundles[6])
                .add(R.id.tree_record_field15, record.fields[7].getFragmentClass(), bundles[7])
                .add(R.id.tree_record_field17, record.fields[8].getFragmentClass(), bundles[8])
                .add(R.id.tree_record_field18, record.fields[9].getFragmentClass(), bundles[9])
                .add(R.id.tree_record_field19, record.fields[10].getFragmentClass(), bundles[10])
                .add(R.id.tree_record_field20, record.fields[11].getFragmentClass(), bundles[11])
                .add(R.id.tree_record_field21, record.fields[12].getFragmentClass(), bundles[12])
                .add(R.id.tree_record_field22, record.fields[13].getFragmentClass(), bundles[13])
                .add(R.id.tree_record_field23, record.fields[14].getFragmentClass(), bundles[14])
                .add(R.id.tree_record_field24, record.fields[15].getFragmentClass(), bundles[15])
                .add(R.id.tree_record_field26, record.fields[16].getFragmentClass(), bundles[16])
                .add(R.id.tree_record_field27, record.fields[17].getFragmentClass(), bundles[17])
                .add(R.id.tree_record_field28, record.fields[18].getFragmentClass(), bundles[18])
                .add(R.id.tree_record_field29, record.fields[19].getFragmentClass(), bundles[19])
                .commit();
    }

    @Override
    public RecordDialogFragment newInstance() {
        return new TreeRecordFragment();
    }
}
