package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavType;
import androidx.navigation.Navigation;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;

public class FormListFragment extends Fragment {

    private PackageViewModel packageViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.forms_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        packageViewModel = PackageViewModel.getInstance(requireActivity());

        Button form1 = view.findViewById(R.id.summary_form);
        Button form2 = view.findViewById(R.id.plot_notes_form);
        Button form3 = view.findViewById(R.id.site_permissions_form);
        Button form4 = view.findViewById(R.id.road_post_location_form);
        Button form5 = view.findViewById(R.id.walkin_form);
        Button form6 = view.findViewById(R.id.plot_location_and_layout_form);
        Button form7 = view.findViewById(R.id.stand_information_form);
        Button form8 = view.findViewById(R.id.photo_form);
        Button form9 = view.findViewById(R.id.vegetation_form);
        Button form10 = view.findViewById(R.id.trees_form);
        Button form11 = view.findViewById(R.id.deformities_and_cavities_form);
        Button form12 = view.findViewById(R.id.height_worksheet_form);
        Button form13 = view.findViewById(R.id.heights_form);
        Button form14 = view.findViewById(R.id.plot_mapping_form);
        Button form15 = view.findViewById(R.id.down_woody_debris_form);
        Button form16 = view.findViewById(R.id.stocking_form);
        Button form17 = view.findViewById(R.id.mortality_form);
        Button form18 = view.findViewById(R.id.ages_form);
        Button form19 = view.findViewById(R.id.test_auger_form);
        Button form20 = view.findViewById(R.id.soil_description_form);
        Button form21 = view.findViewById(R.id.soil_site_form);
        Button form22 = view.findViewById(R.id.trees_self_qa_form);
        Button form23 = view.findViewById(R.id.deformities_self_qa_form);
        Button form24 = view.findViewById(R.id.heights_self_qa_form);


        form1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_summaryFormFragment, new Bundle()));
        form2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_plotNotesFormFragment));
        form3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_sitePermFormFragment));
        form4.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_roadPostLocFormFragment));
        form5.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_walkInFormFragment));
        form6.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_plotLocLayoutFormFragment));
        form7.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_standInfoFormFragment));
        form8.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_photoFormFragment));
        form9.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_vegetationFormFragment));
        form10.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_treeFormFragment));
        form11.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_defCavFormFragment));
        form12.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_heightWorksheetFormFragment));
        form13.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_heightsFormFragment));
        //no destination for this form (plot mapping)
        //form14.setOnClickListener(this);
        form15.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_DWDFormFragment));
        form16.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_stockingFormFragment));
        form17.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_mortalityFormFragment));
        form18.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_agesFormFragment));
        form19.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_testAugerFormFragment));
        form20.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_soilDescriptionFormFragment));
        form21.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_soilSiteFormFragment));
        form22.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_treesSelfQAFormFragment));
        form23.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_deformSelfQAFormFragment));
        form24.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_formListFragment_to_heightsSelfQAFormFragment));
    }

    private View.OnClickListener navigateListener(@IdRes int navAction, int iForm){
        Bundle bundle = new Bundle();
        bundle.putInt("iForm", iForm);
        return Navigation.createNavigateOnClickListener(navAction, bundle);
    }
}