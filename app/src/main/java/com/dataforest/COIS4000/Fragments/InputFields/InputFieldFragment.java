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
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.FormAttr;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

/**
 *
 * @param <T> The subclass of FormAttr that this interacts with.
 * @param <E> The type of UI element this contains.
 */
public abstract class InputFieldFragment<T extends FormAttr<?>, E extends View> extends Fragment {


    @LayoutRes protected int layoutId;  //the xml layout that will be display
    @IdRes protected int nameId;    //id of the TextView that will contain the field name
    @IdRes protected int inputId;   //id of the element that accepts user input

    //these variables are used to share data
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments
    protected int iField; //the index of this field in the PlotForm
    protected int iForm;  //the index of this form in the PlotPackage
    protected int recordKey;  //the key value of the record in packageViewModel.recordMap

    protected T formAttr;
    protected E input;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        //get information required to access FormAttr
        recordKey = requireArguments().getInt("recordKey", -1); //defaults to -1
        iField = requireArguments().getInt("iField");
        iForm = requireArguments().getInt("iForm");

        initFormAttr();
        TextView text = view.findViewById(nameId);
        text.setText(formAttr.name);

        initInput(view);
        setInputListener();
    }

    /**
     *
     * @return True if {@link #formAttr} contains valid data, False otherwise.
     */
    protected abstract boolean isValid();

    /**
     * Use this method to set the value of {@link #formAttr}.
     * Should only be called after {@link #initFormAttr()}.
     */
    protected abstract void updateData();

    /**
     * Sets the appropriate listener for {@link #input}.
     */
    protected abstract void setInputListener();

    /**
     * Sets the value of {@link #formAttr}.
     * Should only be called after the values of {@link #recordKey}, {@link #iForm}, and {@link #iField} are set.
     * Warnings Suppressed: unchecked, ConstantConditions.
     */
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    protected void initFormAttr() throws NullPointerException{
        if(recordKey < 0)
            formAttr = (T) packageViewModel.plotPackage.forms[iForm].fields[iField];
        else
            formAttr = (T) packageViewModel.recordMap.get(recordKey).fields[iField];
    }

    /**
     * Sets the value of {@link #input} and any fields that must be initialized.
     * @param view View argument from {@link #onViewCreated(View, Bundle)}
     */
    protected abstract void initInput(View view);
}
