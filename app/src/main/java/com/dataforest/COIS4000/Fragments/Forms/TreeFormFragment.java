package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Fragments.Forms.Records.TreeRecordFragment;
import com.dataforest.COIS4000.Fragments.InputFields.InputFieldFragment;
import com.dataforest.COIS4000.Fragments.InputFields.RecordListFragment;
import com.dataforest.COIS4000.BackendDataStructures.PlotForm;

import java.util.HashMap;

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
        TreeRecordFragment treeRecordFragment = new TreeRecordFragment();
        packageViewModel.recordDialogs.add(treeRecordFragment);
        int iDialog = packageViewModel.recordDialogs.indexOf(treeRecordFragment);


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
                bundles[i].putInt("iForm", iForm);
                if(form.fields[i] instanceof Record)
                    bundles[i].putInt("iDialog", iDialog);
            }

            fm = getChildFragmentManager();

            //set layout and fragment class for contained fragments, and pass bundles
            fm.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.tree_field1, form.fields[0].getFragmentClass(), bundles[0])
                    .add(R.id.tree_field2, form.fields[1].getFragmentClass(), bundles[1])
                    .add(R.id.tree_field3, form.fields[2].getFragmentClass(), bundles[2])
                    .add(R.id.tree_field4, form.fields[3].getFragmentClass(), bundles[3])
                    .add(R.id.tree_trees_record, form.fields[4].getFragmentClass(), bundles[4])
                    .add(R.id.tree_field30, form.fields[5].getFragmentClass(), bundles[5])  //skip from 3 to 5 as 4 is record
                    .commit();
            /*there is information on receiving parameters in TextFieldFragment.java

             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */

        }
    }
}
