package com.citchennai.cse.moneymanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Budget extends Fragment {


    public Budget() {
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
        getActivity().setTitle("Budget");
        final View view=inflater.inflate(R.layout.fragment_budget, container, false);
        Button btn=(Button) view.findViewById(R.id.setbutton);
        final HashMap<String,String> values=new HashMap<>();
        final Database databasess = new Database(getContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {

                values.put("FOOD",((EditText)(view.findViewById(R.id.food))).getText().toString());
                ((EditText)(view.findViewById(R.id.food))).setText("");
                values.put("EDUCATION",((EditText)(view.findViewById(R.id.education))).getText().toString());
                ((EditText)(view.findViewById(R.id.education))).setText("");
                values.put("EB",((EditText)(view.findViewById(R.id.eb))).getText().toString());
                ((EditText)(view.findViewById(R.id.eb))).setText("");
                values.put("LOANS",((EditText)(view.findViewById(R.id.loans))).getText().toString());
                ((EditText)(view.findViewById(R.id.loans))).setText("");
                values.put("RENT",((EditText)(view.findViewById(R.id.rent))).getText().toString());
                ((EditText)(view.findViewById(R.id.rent))).setText("");
                values.put("FUELS",((EditText)(view.findViewById(R.id.fuels))).getText().toString());
                ((EditText)(view.findViewById(R.id.fuels))).setText("");
                values.put("TRAVEL",((EditText)(view.findViewById(R.id.travel))).getText().toString());
                ((EditText)(view.findViewById(R.id.travel))).setText("");
                values.put("SHOPPING",((EditText)(view.findViewById(R.id.shopping))).getText().toString());
                ((EditText)(view.findViewById(R.id.shopping))).setText("");
                values.put("FARE",((EditText)(view.findViewById(R.id.fare))).getText().toString());
                ((EditText)(view.findViewById(R.id.fare))).setText("");
                values.put("MEDICAL",((EditText)(view.findViewById(R.id.medical))).getText().toString());
                ((EditText)(view.findViewById(R.id.medical))).setText("");
                values.put("CLOTHES",((EditText)(view.findViewById(R.id.clothes))).getText().toString());
                ((EditText)(view.findViewById(R.id.clothes))).setText("");
                values.put("RECHARGE",((EditText)(view.findViewById(R.id.recharge))).getText().toString());
                ((EditText)(view.findViewById(R.id.recharge))).setText("");
                values.put("INTERNET PAYMENT",((EditText)(view.findViewById(R.id.internet))).getText().toString());
                ((EditText)(view.findViewById(R.id.internet))).setText("");
                values.put("OTHERS",((EditText)(view.findViewById(R.id.others))).getText().toString());
                ((EditText)(view.findViewById(R.id.others))).setText("");
                for(Map.Entry<String,String> mp: values.entrySet())
                {
                    try {
                        if(mp.getValue().isEmpty())
                        {
                            continue;
                        }
                        boolean is = databasess.InsertMyExpenses(true, Integer.parseInt(mp.getValue()), mp.getKey(), "");
                        if (is) {
                            Toast.makeText(getContext(), "Created", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
                        }
                    }catch (NumberFormatException ne)
                    {
                        ne.printStackTrace();
                    }
                }
            }
        });
        return view;
    }

    }

