package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;

import java.util.ArrayList;

public class VisitTypeFragment extends Fragment {

    private PackageViewModel packageViewModel;


    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null. This will be called between
     * {@link #onCreate(Bundle)} and {@link #onViewCreated(View, Bundle)}.
     * <p>A default View can be returned by calling {@link Fragment(int)} in your
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
        return inflater.inflate(R.layout.form_visit_type, container, false);
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        packageViewModel = PackageViewModel.getInstance(requireActivity());
        Button submit = view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox current;
                ArrayList<String> visitTypes = new ArrayList<>();

                int[] visitTypeIds = {R.id.check_locate, R.id.check_establish, R.id.check_recon, R.id.check_remeasure, R.id.check_post_treat, R.id.check_correction, R.id.check_confirm, R.id.check_qa};
                String[] visitTypeStrings = {PlotPackage.LOCATE, PlotPackage.ESTAB, PlotPackage.RECON, PlotPackage.REMEASURE, PlotPackage.PST_TREAT, PlotPackage.CORRECT, PlotPackage.CONFIRM, PlotPackage.QA};

                for(int i = 0; i < visitTypeIds.length; i++){
                    current = view.findViewById(visitTypeIds[i]);
                    if(current.isChecked())
                        visitTypes.add(visitTypeStrings[i]);
                }

                packageViewModel.init(requireActivity().getAssets(), visitTypes);

                Navigation.findNavController(view).navigate(R.id.action_formList);
            }
        });
    }
}
