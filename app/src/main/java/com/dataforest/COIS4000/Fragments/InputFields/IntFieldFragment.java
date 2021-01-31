package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.R;

public class IntFieldFragment extends Fragment {
    private View view;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.input_number, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //this gets the text field you want to change
        TextView text = (TextView) view.findViewById(R.id.numberFieldName);

        //this gets a value from the bundle
        String name = requireArguments().getString("name");

        //this sets text
        text.setText(name);
    }
}
