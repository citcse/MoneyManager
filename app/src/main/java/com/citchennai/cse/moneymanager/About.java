package com.citchennai.cse.moneymanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Aravind on 12/4/2016.
 */

public class About extends Fragment {
    TextView t;


    public About() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("About");
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView t = (TextView) view.findViewById(R.id.about);
        t.setText("Our application is designed in a such a way, that it can be accessed by the end user without the internet connectivity. This allows the user to work with our attractive user interface with well facilitated environment to manage their daily expenditure without the network connectivity in a effective manner. The next common problem \"Complexity\" is resolved by the elegant user friendly interfaces that is designed by us in our application.\n \nFOUNDERS:\n 1.Divya.I \n 2.Aravind Raja.M \n 3.Annamalai.A\n 4.Karuppasamy.B\n 5.Saran.G\n 6.ShanmugaPriya.R \n 7.Sasikala.S ");


        return view;

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}