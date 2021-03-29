package com.dataforest.COIS4000.Fragments.Forms;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.Fragment;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;

public class RecordDialogFragment extends DialogFragment {

    private final float WIDTH_PERCENT = 0.75f;
    private final float HEIGHT_PERCENT = 0.75f;

    protected Record record;
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments

    protected int iForm;
    protected int recordKey;  //the key value of the record in packageViewModel.recordMap

    protected Bundle[] bundles;

    private LinearLayout fieldList;
    private final LayoutParams FIELD_PARAMS = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);


    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null. This will be called between
     * {@link #onCreate(Bundle)} and {@link #onViewCreated(View, Bundle)}.
     * <p>A default View can be returned by calling Fragment(int) in your
     * constructor. Otherwise, this method returns null.
     *
     * <p>It is recommended to <strong>only</strong> inflate the layout in this method and move
     * logic that operates on the returned View to {@link #onViewCreated(View, Bundle)}.
     *
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams((int) (dm.widthPixels * WIDTH_PERCENT), (int) (dm.heightPixels * HEIGHT_PERCENT));

        requireDialog().setContentView(view, lp);
        packageViewModel = PackageViewModel.getInstance(requireActivity());

        fieldList = view.findViewById(R.id.FieldList);

        iForm = requireArguments().getInt("iForm");
        recordKey = requireArguments().getInt("recordKey");

        record = packageViewModel.recordMap.get(recordKey);

        FragmentTransaction addField = getChildFragmentManager().beginTransaction().setReorderingAllowed(true);

        bundles = new Bundle[record.fields.length];
        for(int i = 0; i < bundles.length; i++){
            bundles[i] = new Bundle();

            bundles[i].putInt("recordKey", recordKey);


            bundles[i].putInt("iForm", iForm);
            bundles[i].putInt("iField", i);
            addField.add(addFragmentContainerView(), record.fields[i].getFragmentClass(), bundles[i]);
        }

        addField.commit();
    }

    /**
     * Adds a FragmentContainerView to this record.
     * @return The id of the new FragmentContainerView.
     * @see FragmentContainerView
     */
    @IdRes
    private int addFragmentContainerView(){
        FragmentContainerView fcv = new FragmentContainerView(requireContext());
        fcv.setId(ViewCompat.generateViewId());
        fieldList.addView(fcv, FIELD_PARAMS);
        return fcv.getId();
    }

    public RecordDialogFragment newInstance(){
        return new RecordDialogFragment();
    }
}
