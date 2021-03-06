package com.citchennai.cse.moneymanager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MyExpenses extends Fragment {


    public MyExpenses() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("My Expenses");
        View view = inflater.inflate(R.layout.fragment_my_expenses, container, false);
        final Spinner spinner = (Spinner)view.findViewById(R.id.catspineee);
        Button btn=(Button) view.findViewById(R.id.myexp_set);
        final EditText amount=(EditText)view.findViewById(R.id.amount);
        final Database databasess = new Database(getContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean is=databasess.InsertMyExpenses(false,-Integer.parseInt(amount.getText().toString()),spinner.getSelectedItem().toString(),"");
                amount.setText("");
                if(is){
                    Toast.makeText(getContext(), "Sucessfull", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}