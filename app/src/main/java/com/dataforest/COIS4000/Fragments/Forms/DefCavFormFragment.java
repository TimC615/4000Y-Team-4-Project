package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dataforest.COIS4000.BackendDataStructures.R;

/*
*
* need to create RecordDialogFragments for deformities record and cavities record
*
*
* */
public class DefCavFormFragment extends FormFragment {

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
