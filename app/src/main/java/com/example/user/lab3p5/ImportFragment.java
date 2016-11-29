package com.example.user.lab3p5;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportFragment extends Fragment {
    EditText editText;

    public ImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_import, container, false);
        //Link UI to program
        editText = (EditText) view.findViewById(R.id.editTextFileName);
        Button buttonBrowse;
        buttonBrowse = (Button) view.findViewById(R.id.buttonBrowse);
        buttonBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("File name :"+editText.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onPause(){
        super.onPause();
        //Create an instance of Shared Preference
        SharedPreferences mySharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(getString(R.string.filename),editText.getText().toString());
        editor.commit();

    }

    @Override
    public void onResume() {
        super.onResume();
        //Create an instance of Shared Preference
        SharedPreferences mySharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String fileNAme = mySharedPreferences.getString(getString(R.string.filename).toString(),null);
        editText.setText(fileNAme);
    }
}
