package com.dataforest.COIS4000.Fragments.InputFields;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dataforest.COIS4000.BackendDataStructures.R;

public class TextFieldFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.input_text, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //this gets the text field you want to change
        TextView text = (TextView) view.findViewById(R.id.textFieldName);

        //this gets a value from the bundle
        String name = requireArguments().getString("name");

        //this sets text
        text.setText(name);

        /*

        This is just for learning about passing data

        Button b = view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = new Bundle();
                EditText text = view.findViewById(R.id.textInput);
                b.putString("title", text.getText().toString());
                getParentFragmentManager().setFragmentResult("return", b);
            }
        });

        */
    }
}