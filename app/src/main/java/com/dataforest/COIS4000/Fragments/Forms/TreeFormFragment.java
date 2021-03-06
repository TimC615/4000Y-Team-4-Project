package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.PlotForm;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;
import com.dataforest.COIS4000.Fragments.Forms.Records.TreeRecordFragment;

import java.util.ArrayList;

public class TreeFormFragment extends FormFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        iForm = 0;
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.form_tree;
    }

    @Override
    protected RecordDialogFragment[] getRecordFragmentInstances() {
        RecordDialogFragment[] array = new RecordDialogFragment[1];
        array[0] = new TreeRecordFragment();
        return array;
    }

    /**
     * @return An array of ids for FragmentContainers, which will contain fragments for user input.
     */
    @Override
    protected int[] getFragmentContainerIds() {
        @IdRes int[] ids = {
                R.id.tree_field1,
                R.id.tree_field2,
                R.id.tree_field3,
                R.id.tree_field4,
                R.id.tree_trees_record,
                R.id.tree_field30
        };
        return ids;
    }


}
