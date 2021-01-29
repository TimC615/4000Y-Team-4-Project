package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Forms.TreeForm;


/*
*
* NOTE: Right now this class does nothing.
* This class will replace TreeFormActivity once the navigation is set up and data structures are complete.
*
* */
public class TreeFormFragment extends Fragment {

    private View view;

    private TreeForm form;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.form_tree, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if(savedInstanceState == null){

            //create a bundle for each field
            Bundle[] bundles = new Bundle[form.fields.length];   //will instead use form object field array
            for (int i = 0; i < bundles.length; i++){
                bundles[i] = new Bundle();

                //add a value to the bundle as a key-value pair
                bundles[i].putString("name", form.fields[i].name);
            }

            //set layout and fragment class for contained fragments, and pass bundles
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.tree_field1, form.fields[0].getFragmentClass(), bundles[0])
                    .add(R.id.tree_field2, form.fields[1].getFragmentClass(), bundles[1])
                    .add(R.id.tree_field3, form.fields[2].getFragmentClass(), bundles[2])
                    .add(R.id.tree_field4, form.fields[3].getFragmentClass(), bundles[3])
                    .add(R.id.tree_field30, form.fields[4].getFragmentClass(), bundles[5])
                    .commit();

            /*there is information on receiving parameters in TextFieldFragment.java
             * there is xml stuff that needs to be for each fragment as well, this is in tree_form.xml
             * */
        }
    }
}
