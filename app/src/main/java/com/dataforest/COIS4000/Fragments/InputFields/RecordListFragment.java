package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.Fragments.Forms.TreeRecordFragment;

import java.util.HashMap;

public class RecordListFragment extends Fragment {
    //these variables are used to interact with the layout
    @LayoutRes private int layoutId = R.layout.blueprint_record;  //the xml layout that will be display (hardcode)
    @IdRes private int buttonId = R.id.new_record_button;   //the button that will add records
    @IdRes private int listId = R.id.record_entries;    //the linear layout that will contain new records

    //these variables are used to share data
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments
    private int iField; //the index of this field in the PlotForm
    private int iForm;  //the index of this form in the PlotPackage

    private Button addRecord;
    private LinearLayout recordList;
    private final LinearLayout.LayoutParams recordParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);   //defines how the records will show up in the list
    private HashMap<Integer, RecordDialogFragment> fragmentMap;
    private String recordName;

    private View view;

    //this method is called to add a new record
    View.OnClickListener addRecordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button newRecord = new Button(getContext());

            String idString = recordName + (fragmentMap.size() + 1);
            newRecord.setText(idString);
            newRecord.setId(ViewCompat.generateViewId());   //generate id
            TreeRecordFragment record = new TreeRecordFragment();

            //pass field index information
            Bundle bundle = new Bundle();
            bundle.putInt("iForm", iForm);
            bundle.putInt("iField", iField);
            record.setArguments(bundle);
            fragmentMap.put(newRecord.getId(), record);   //TreeRecordFragment is temp

            recordList.addView(newRecord, recordParams);
            newRecord.setOnClickListener(openRecordListener);
            fragmentMap.get(newRecord.getId()).show(getChildFragmentManager(), null);
        }
    };

    //this method is called to open a record
    View.OnClickListener openRecordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecordDialogFragment record = fragmentMap.get(v.getId());

            //display the dialog fragment
            record.show(getChildFragmentManager(), null);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(layoutId, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        //this gets a value from the bundle
        iField = requireArguments().getInt("iField");   //field index
        iForm = requireArguments().getInt("iForm"); //form index

        addRecord = (Button) view.findViewById(buttonId);
        addRecord.setOnClickListener(addRecordListener);

        recordList = (LinearLayout) view.findViewById(listId);

        recordName = packageViewModel.plotPackage.forms[iForm].fields[iField].name; //this gets the naming convention for the record buttons
        fragmentMap = new HashMap<>();
    }
}
