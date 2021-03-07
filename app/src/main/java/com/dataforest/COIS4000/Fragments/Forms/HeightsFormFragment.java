package com.dataforest.COIS4000.Fragments.Forms;

import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;
import com.dataforest.COIS4000.Fragments.Forms.Records.TreeRecordFragment;

//currently actually creating a TreeForm
public class HeightsFormFragment extends FormFragment {
    /**
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.form_heights;
    }

    /**
     * @return An array containing a new instance of each RecordDialogFragment that will appear in this form.
     * If a type of RecordDialogFragment appears multiple times in this form, it must be repeated in the array.
     */
    @Override
    protected RecordDialogFragment[] getRecordFragmentInstances() {
        RecordDialogFragment[] array = {new TreeRecordFragment()};
        return array;
    }

    /**
     * @return An array of ids for FragmentContainers, which will contain fragments for user input.
     */
    @Override
    protected int[] getFragmentContainerIds() {
        int[] array = {
                R.id.heights_field1,
                R.id.heights_field2,
                R.id.heights_field3,
                R.id.heights_field4,
                R.id.heights_height_record,
                R.id.heights_field17
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
        return "Heights";
    }

}
