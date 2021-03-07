package com.dataforest.COIS4000.Fragments.Forms;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;
import com.dataforest.COIS4000.Fragments.Forms.Records.TreeRecordFragment;

public class StockingFormFragment extends FormFragment {
    /**
     * @return The id of the xml layout that this form uses.
     */
    @Override
    protected int getLayoutId() {
        return R.layout.form_stocking;
    }

    /**
     * @return An array containing a new instance of each RecordDialogFragment that will appear in this form.
     * @implNote If a type of RecordDialogFragment appears multiple times in this form, it must be repeated in the array.
     */
    @Override
    protected RecordDialogFragment[] getRecordFragmentInstances() {
        RecordDialogFragment[] array = {
                new TreeRecordFragment(),
                new TreeRecordFragment()
        };
        return array;
    }

    /**
     * @return An array of ids for FragmentContainers, which will contain fragments for user input.
     */
    @Override
    protected int[] getFragmentContainerIds() {
        @IdRes int[] array = {
                R.id.stocking_field1,
                R.id.stocking_field2,
                R.id.stocking_stock_record,
                R.id.stocking_record2,
                R.id.stocking_field10
        };
        return array;
    }

    /**
     * Get the name of this form. The name will be used to find the index of this form.
     *
     * @return The name of this form as it appears in the form constructor.
     */
    @Override
    protected String getFormName() {
        return "Stocking";
    }

}
