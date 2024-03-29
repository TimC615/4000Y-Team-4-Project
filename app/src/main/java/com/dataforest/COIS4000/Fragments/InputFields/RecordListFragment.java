package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dataforest.COIS4000.BackendDataStructures.PackageViewModel;
import com.dataforest.COIS4000.BackendDataStructures.R;
import com.dataforest.COIS4000.BackendDataStructures.UIComponents.Record;
import com.dataforest.COIS4000.Fragments.Forms.RecordDialogFragment;

public class RecordListFragment extends Fragment {
    //these variables are used to interact with the layout
    @LayoutRes private int layoutId = R.layout.input_record;  //the xml layout that will be display (hardcode)
    @IdRes private int buttonId = R.id.new_record_button;   //the button that will add records
    @IdRes private int listId = R.id.record_entries;    //the linear layout that will contain new records

    //these variables are used to share data
    protected PackageViewModel packageViewModel;    //PackageViewModel contains data shared between fragments
    private int iField; //the index of this field in the PlotForm
    private int iForm;  //the index of this form in the PlotPackage
    private Record currentRecord;  //the first record in the linked list


    private Button addRecord;
    private LinearLayout recordList;
    private final LinearLayout.LayoutParams recordParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);   //defines how the records will show up in the list
    private String recordName;

    private View view;

    //this method is called to add a new record
    View.OnClickListener addRecordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addRecord().show(getChildFragmentManager(), null);
        }
    };

    //this method is called to open a record
    View.OnClickListener openRecordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecordDialogFragment record = new RecordDialogFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("iForm", iForm);
            bundle.putInt("recordKey", v.getId());
            record.setArguments(bundle);

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

        //adds this fragment to the view model scope; a new view model is created if one does not exist
        packageViewModel = new ViewModelProvider(requireActivity()).get(PackageViewModel.class);

        //this gets a value from the bundle
        iField = requireArguments().getInt("iField");   //field index
        iForm = requireArguments().getInt("iForm"); //form index


        recordList = (LinearLayout) view.findViewById(listId);
        currentRecord = (Record) packageViewModel.plotPackage.forms[iForm].fields[iField];
        recordName = currentRecord.name; //this gets the naming convention for the record buttons

        initList();

        addRecord = (Button) view.findViewById(buttonId);
        addRecord.setOnClickListener(addRecordListener);
        String addRecordText = "Add New " + recordName;
        addRecord.setText(addRecordText);
    }

    private void initList(){
        int count = currentRecord.Count();

        while(currentRecord != null && currentRecord.getRecordMapKey() != -1){
            addExistingRecord(currentRecord.getRecordMapKey(), count - currentRecord.countRemaining());
            currentRecord = currentRecord.getNext();
        }
    }

    private void addExistingRecord(int recordMapKey, int recordNum){
        Button existingRecord = new Button(requireContext());
        existingRecord.setId(recordMapKey);

        String buttonText = recordName + " " + recordNum;
        existingRecord.setText(buttonText);
        existingRecord.setOnClickListener(openRecordListener);
        recordList.addView(existingRecord, recordParams);
    }

    private RecordDialogFragment addRecord(){
        Button newRecord = new Button(getContext());
        RecordDialogFragment record = new RecordDialogFragment();

        String buttonText = recordName + " " + (currentRecord.Count());
        newRecord.setText(buttonText);
        newRecord.setId(ViewCompat.generateViewId());   //generate id

        //add new elements to hashmap
        packageViewModel.recordMap.put(newRecord.getId(), currentRecord);
        currentRecord.setRecordMapKey(newRecord.getId());
        currentRecord = currentRecord.addRecord();

        //pass field index information
        Bundle bundle = new Bundle();
        bundle.putInt("iForm", iForm);
        bundle.putInt("recordKey", newRecord.getId());
        record.setArguments(bundle);

        recordList.addView(newRecord, recordParams);
        newRecord.setOnClickListener(openRecordListener);
        return record;
    }
}
