package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;

public class RecordFragment extends Fragment {
    //these variables are used to interact with the layout
    @LayoutRes protected int layoutId;  //the xml layout that will be display (hardcode)
    @IdRes protected int nameId;    //id of the TextView that will contain the field name(hardcode)
    protected View view;    //used to interact with the layout after fragment creation (maybe unnecessary?)

    //these variables are used to share data
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments
    private int iField; //the index of this field in the PlotForm
    private int iForm;  //the index of this form in the PlotPackage

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(layoutId, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        /*
         * How data will be passed to field fragments:
         *       the form fragment will pass a bundle containing the field index of this fragment,
         *       the bundle will also contain the index of the form in the plot package
         *       the data for this fragment will go into:
         *               packageViewModel.plotPackage.forms[formIndex].fields[fieldIndex]
         *
         *
         * */

        //this gets the text field you want to change
        TextView text = view.findViewById(nameId);

        //this gets a value from the bundle
        iField = requireArguments().getInt("iField");   //field index
        iForm = requireArguments().getInt("iForm"); //form index

        //get field name from plot package
        String name = packageViewModel.plotPackage.forms[iForm].fields[iField].name;

        //this sets text
        text.setText(name);
    }
}