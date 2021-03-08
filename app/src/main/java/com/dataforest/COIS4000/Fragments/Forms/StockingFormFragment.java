package com.dataforest.COIS4000.Fragments.Forms;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;

public class StockingFormFragment extends FormFragment {

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
