package com.dataforest.COIS4000.Fragments.Forms;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;
import com.dataforest.COIS4000.Fragments.Forms.Records.TreeRecordFragment;

public class DWDFormFragment extends FormFragment {
    /**
     * @return The id of the xml layout that this form uses.
     */
    @Override
    protected int getLayoutId() {
        return R.layout.form_dwd;
    }

    /**
     * @return An array containing a new instance of each RecordDialogFragment that will appear in this form.
     * @implNote If a type of RecordDialogFragment appears multiple times in this form, it must be repeated in the array.
     */
    @Override
    protected RecordDialogFragment[] getRecordFragmentInstances() {
        RecordDialogFragment[] array =  {
                new TreeRecordFragment(),
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
                R.id.dwd_field1,
                R.id.dwd_field2,
                R.id.dwd_cwd_record,
                R.id.dwd_accumulation_record,
                R.id.dwd_dwdline_record,
                R.id.dwd_field22
        };
        return array;
    }

    /**
     * Get the index of this form using {@link PlotPackage#getFormIndex(String)}.
     *
     * @return The index of this form in PlotPackage.forms
     */
    @Override
    protected int getFormIndex() {
        return packageViewModel.plotPackage.getFormIndex("Down Woody Debris");
    }
}
