package com.citchennai.cse.moneymanager;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Aravind on 12/3/2016.
 */

public class Charts extends Fragment {
    public  Charts()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Charts");
        View view = inflater.inflate(R.layout.fragment_charts, container, false);
        ArrayList<Bar> points = new ArrayList<Bar>();
        Bar d = new Bar();
        d.setColor(Color.parseColor("#000000"));
        d.setName("Dec");


        Database db=new Database(getContext());
        Cursor c=db.GetChart("12");
        while(c.moveToNext())
            d.setValue(Integer.parseInt(c.getString(0)));

        Bar d2 = new Bar();
        d2.setColor(Color.parseColor("#000000"));
        d2.setName("Oct");
        d2.setValue(0);
        Bar d3 = new Bar();
        d3.setColor(Color.parseColor("#000000"));
        d3.setName("Nov");
        d3.setValue(0);
        points.add(d2);
        points.add(d3);
        points.add(d);


        BarGraph g = (BarGraph)view.findViewById(R.id.graph);
        g.setBars(points);
        g.setUnit("Rs ");


        return view;
    }
}
