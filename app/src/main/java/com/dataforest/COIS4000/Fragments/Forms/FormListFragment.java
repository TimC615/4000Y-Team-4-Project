package com.dataforest.COIS4000.Fragments.Forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavType;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.PlotPackage;
import com.dataforest.COIS4000.BackendDataStructures.R;

public class FormListFragment extends Fragment {

    private PackageViewModel packageViewModel;

    private LinearLayout buttonList;
    private final LayoutParams BUTTON_PARAMS = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.forms_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        packageViewModel = PackageViewModel.getInstance(requireActivity());

        if(!packageViewModel.isInitialized()){
            Navigation.findNavController(view).navigate(R.id.action_visitTypes);
        }
        else{
            buttonList = view.findViewById(R.id.ButtonList);

            for(int i = 0; i < packageViewModel.plotPackage.forms.length; i++){
                switch (packageViewModel.plotPackage.forms[i].getRequireComplete()){
                    case PlotPackage.EXCLUDE:
                        break;
                    default:
                        addButton(i);

                }
            }
        }




    }


    private void addButton(int iForm){
        Button button = new Button(requireContext());
        button.setText(packageViewModel.plotPackage.forms[iForm].formName);
        button.setOnClickListener(navigateListener(iForm));
        buttonList.addView(button, BUTTON_PARAMS);
    }

    private View.OnClickListener navigateListener(int iForm){
        Bundle bundle = new Bundle();
        bundle.putInt("iForm", iForm);
        return Navigation.createNavigateOnClickListener(R.id.action_form, bundle);
    }
}