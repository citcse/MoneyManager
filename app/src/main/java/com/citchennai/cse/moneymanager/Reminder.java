package com.citchennai.cse.moneymanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reminder extends Fragment {

    public Reminder() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Reminder");
        View view = inflater.inflate(R.layout.fragment_reminder, container, false);
        final Database database = new Database(getContext());
        database.update();
        Button note_button=(Button)view.findViewById(R.id.remainder_button);
        final EditText notes_data=(EditText) view.findViewById(R.id.note_data);
        note_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        boolean insertstatus=database.InsertNote(notes_data.getText().toString());
                if(insertstatus)
                    Toast.makeText(getContext(), "Succesfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
