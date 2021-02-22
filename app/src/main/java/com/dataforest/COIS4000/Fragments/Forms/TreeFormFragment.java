package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Forms.PlotForm;
import com.dataforest.COIS4000.Fragments.InputFields.InputFieldFragment;

import java.util.Iterator;
import java.util.List;

/*
*
* still need to attach record
*
* */
public class TreeFormFragment extends Fragment {

    private View view;

    private PlotForm form;

    private PackageViewModel packageViewModel;

    private int iForm = 0;  //used to indicate index in PlotPackage object

    private FragmentManager fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.form_tree, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        form = packageViewModel.plotPackage.forms[0];

        /*
         * How data will be passed to form fragments:
         *       the form fragment will pass a bundle containing the form index of this fragment
         * 
         *       the data for this fragment will go into:
         *               packageViewModel.plotPackage.forms[formIndex]
         *
         * */

        if(savedInstanceState == null){

            //create a bundle for each field
            Bundle[] bundles = new Bundle[form.fields.length];
            for (int i = 0; i < bundles.length; i++){
                bundles[i] = new Bundle();

                //add a value to the bundle as a key-value pair
                bundles[i].putInt("iField", i);
                bundles[i].putInt("iForm", iForm);  //replace 0 with actual form index
            }

            fm = getChildFragmentManager();

            //set layout and fragment class for contained fragments, and pass bundles
            fm.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.tree_field1, form.fields[0].getFragmentClass(), bundles[0])
                    .add(R.id.tree_field2, form.fields[1].getFragmentClass(), bundles[1])
                    .add(R.id.tree_field3, form.fields[2].getFragmentClass(), bundles[2])
                    .add(R.id.tree_field4, form.fields[3].getFragmentClass(), bundles[3])
                    .add(R.id.tree_field30, form.fields[5].getFragmentClass(), bundles[5])
                    .commit();

            /*there is information on receiving parameters in TextFieldFragment.java
             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */
        }
    }
}
