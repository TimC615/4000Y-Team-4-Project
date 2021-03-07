package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.Forms.Records.RecordDialogFragment;
import com.dataforest.COIS4000.Fragments.Forms.Records.TreeRecordFragment;

/*
*
* need to create RecordDialogFragments for deformities record and cavities record
*
*
* */
public class DefCavFormFragment extends FormFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        iForm = 1;
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.form_def_cav;
    }

    /**
     * @return An array containing a new instance of each RecordDialogFragment that will appear in this form.
     * If a type of RecordDialogFragment appears multiple times in this form, it must be repeated in the array.
     */
    @Override
    protected RecordDialogFragment[] getRecordFragmentInstances() {
        RecordDialogFragment[] array = new RecordDialogFragment[2];
        array[0] = new TreeRecordFragment();    //haven't made actual fragments yet
        array[1] = new TreeRecordFragment();    //haven't made actual fragments yet
        return array;
    }

    /**
     * @return An array of ids for FragmentContainers, which will contain fragments for user input.
     */
    @Override
    protected int[] getFragmentContainerIds() {
        @IdRes int[] ids = {
            R.id.def_cav_field1,
                R.id.def_cav_field2,
                R.id.def_cav_field3,
                R.id.def_cav_deformity_record,
                R.id.def_cav_cavity_record,
                R.id.def_cav_field4
        };

        return ids;
    }

    /**
     * Get the name of this form. The name will be used to find the index of this form.
     *
     * @return The name of this form as it appears in the form constructor.
     */
    @Override
    protected String getFormName() {
        return "Deformities and Cavities";
    }

}
