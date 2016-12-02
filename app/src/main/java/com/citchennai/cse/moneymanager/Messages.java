package com.citchennai.cse.moneymanager;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

//import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Aravind on 11/30/2016.
 */

import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Messages extends Fragment {


    public Messages() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Messages");
        View view=inflater.inflate(R.layout.messages, container, false);
        TextView tw=(TextView)view.findViewById(R.id.totall);
        Database db=new Database(getContext());
        Cursor c=db.GetTotal();
        while(c.moveToNext())
        tw.setText("BALANCE - Rs. "+c.getString(0));
        ListView ls=(ListView)view.findViewById(R.id.messages);

        String[] a = {"ss"};
        ArrayList<String> st=new ArrayList<>();
        ArrayList<Integer> ints=new ArrayList<>();
        ArrayList<Cursor> stn=new ArrayList<>();
        int[] mm = {R.drawable.ic_delete_white_48dp};

        Cursor result=db.GetMessage();
        while(result.moveToNext()) {
            if(result.getString(1).equals("0"))
            {
                st.add("Your's expanse is Rs "+result.getString(2).replace("-","")+"" +
                        "\n" +
                        ""+result.getString(5));
                ints.add(result.getInt(0));
            }
            else if(result.getString(1).equals("1")){
                ints.add(result.getInt(0));
                st.add("You have set "+result.getString(3).replace("Budget","").trim().toLowerCase()+" budget to "+result.getString(2)+
                        "\n" +
                        ""+result.getString(5));
            }else if(result.getString(1).equals("3")){
                ints.add(result.getInt(0));
                st.add("You have set a note "+result.getString(4).trim()+
                        "\n" +
                        ""+result.getString(5));
            }

        }
        String[] stockArr = new String[st.size()];
        stockArr = st.toArray(stockArr);
        Integer[] ims=new Integer[ints.size()];
        ims=ints.toArray(ims);
        ls.setAdapter(new CustomAdapter(getActivity(), stockArr, ims,result,db,tw));
        return view;

    }

}


