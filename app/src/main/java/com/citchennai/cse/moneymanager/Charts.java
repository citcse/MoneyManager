package com.citchennai.cse.moneymanager;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

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
        final View view = inflater.inflate(R.layout.fragment_charts, container, false);

        final Bar d = new Bar();
        final Database db=new Database(getContext());
        d.setColor(Color.parseColor("#000000"));
        final Spinner from=(Spinner)view.findViewById(R.id.from_spinner);
        final Spinner to=(Spinner) view.findViewById(R.id.to_spinner);
        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
         //       Toast.makeText(getContext(), from.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                final ArrayList<Bar> points = new ArrayList<Bar>();
            int from_int=monthfromname(from.getSelectedItem().toString());
                int to_int=monthfromname(to.getSelectedItem().toString());
                if(from_int>to_int)
                {
                    int diff=from_int-to_int;
                    if(diff==0)
                    {
                        Bar gend = new Bar();
                        gend.setColor(Color.parseColor("#000000"));
                        gend.setName("rand");

                        Cursor c=db.GetChart(to_int+"");
                        while(c.moveToNext())
                        {
                            try {
                                gend.setValue(Integer.parseInt(c.getString(0)));
                            }catch (NumberFormatException ne)
                            {
                                ne.printStackTrace();
                                gend.setValue(0);
                            }
                        }
                        points.add(gend);
                    }else
                    for(int i=0;i<=diff;i++)
                    {
                        Bar gend = new Bar();
                        gend.setColor(Color.parseColor("#000000"));
                        gend.setName(name2month(to_int));

                        Cursor c=db.GetChart(to_int+"");
                        to_int++;
                        while(c.moveToNext())
                        {
                            try {
                                gend.setValue(Integer.parseInt(c.getString(0)));
                            }catch (NumberFormatException ne)
                            {
                                ne.printStackTrace();
                                gend.setValue(0);
                            }
                        }
                        points.add(gend);
                    }
                    BarGraph g = (BarGraph)view.findViewById(R.id.graph);
                    g.setBars(points);
                    g.setUnit("₹");
                }else {







                    int diff=to_int-from_int;
                    if(diff==0)
                    {
                        Bar gend = new Bar();
                        gend.setColor(Color.parseColor("#000000"));
                        gend.setName("rand");

                        Cursor c=db.GetChart(from_int+"");
                        while(c.moveToNext())
                        {
                            try {
                                gend.setValue(Integer.parseInt(c.getString(0)));
                            }catch (NumberFormatException ne)
                            {
                                ne.printStackTrace();
                                gend.setValue(0);
                            }
                        }
                        points.add(gend);
                    }else
                        for(int i=0;i<=diff;i++)
                        {
                            Bar gend = new Bar();
                            gend.setColor(Color.parseColor("#000000"));
                            gend.setName(name2month(from_int));

                            Cursor c=db.GetChart(from_int+"");
                            from_int++;
                            while(c.moveToNext())
                            {
                                try {
                                    gend.setValue(Integer.parseInt(c.getString(0)));
                                }catch (NumberFormatException ne)
                                {
                                    ne.printStackTrace();
                                    gend.setValue(0);
                                }
                            }
                            points.add(gend);
                        }



















                }




                BarGraph g = (BarGraph)view.findViewById(R.id.graph);
                g.setBars(points);
                g.setUnit("₹");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                //       Toast.makeText(getContext(), from.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                final ArrayList<Bar> points = new ArrayList<Bar>();
                int from_int=monthfromname(from.getSelectedItem().toString());
                int to_int=monthfromname(to.getSelectedItem().toString());
                if(from_int>to_int)
                {
                    int diff=from_int-to_int;
                    if(diff==0)
                    {
                        Bar gend = new Bar();
                        gend.setColor(Color.parseColor("#000000"));
                        gend.setName("rand");

                        Cursor c=db.GetChart(to_int+"");
                        while(c.moveToNext())
                        {
                            try {
                                gend.setValue(Integer.parseInt(c.getString(0)));
                            }catch (NumberFormatException ne)
                            {
                                ne.printStackTrace();
                                gend.setValue(0);
                            }
                        }
                        points.add(gend);
                    }else
                        for(int i=0;i<=diff;i++)
                        {
                            Bar gend = new Bar();
                            gend.setColor(Color.parseColor("#000000"));
                            gend.setName(name2month(to_int));

                            Cursor c=db.GetChart(to_int+"");
                            to_int++;
                            while(c.moveToNext())
                            {
                                try {
                                    gend.setValue(Integer.parseInt(c.getString(0)));
                                }catch (NumberFormatException ne)
                                {
                                    ne.printStackTrace();
                                    gend.setValue(0);
                                }
                            }
                            points.add(gend);
                        }
                    BarGraph g = (BarGraph)view.findViewById(R.id.graph);
                    g.setBars(points);
                    g.setUnit("₹");
                }else {







                    int diff=to_int-from_int;
                    if(diff==0)
                    {
                        Bar gend = new Bar();
                        gend.setColor(Color.parseColor("#000000"));
                        gend.setName("rand");

                        Cursor c=db.GetChart(from_int+"");
                        while(c.moveToNext())
                        {
                            try {
                                gend.setValue(Integer.parseInt(c.getString(0)));
                            }catch (NumberFormatException ne)
                            {
                                ne.printStackTrace();
                                gend.setValue(0);
                            }
                        }
                        points.add(gend);
                    }else
                        for(int i=0;i<=diff;i++)
                        {
                            Bar gend = new Bar();
                            gend.setColor(Color.parseColor("#000000"));
                            gend.setName(name2month(from_int));

                            Cursor c=db.GetChart(from_int+"");
                            from_int++;
                            while(c.moveToNext())
                            {
                                try {
                                    gend.setValue(Integer.parseInt(c.getString(0)));
                                }catch (NumberFormatException ne)
                                {
                                    ne.printStackTrace();
                                    gend.setValue(0);
                                }
                            }
                            points.add(gend);
                        }



















                }




                BarGraph g = (BarGraph)view.findViewById(R.id.graph);
                g.setBars(points);
                g.setUnit("₹");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });







        return view;
    }

   
    public static int monthfromname(String name)
    {
        int mon=0;
        switch (name)
        {
        case "JAN":
        mon=1;
        break;
        case "FEB":
        mon=2;
        break;
        case "MAR":
        mon=3;
        break;
        case "APR":
        mon=4;
        break;
        case "MAY":
        mon=5;
        break;
        case "JUN":
        mon=6;
        break;
        case "JULY":
        mon=7;
        break;
        case "AUG":
        mon=8;
        break;
        case "SEPT":
        mon=9;
        break;
        case "OCT":
        mon=10;
        break;
        case "NOV":
        mon=11;
        break;
        case "DEC":
        mon=12;
        break;
        }
        return mon;
    }
    public static String name2month(int month)
    {
        String names="";
        switch (month)
        {

            case 1:
                names="JAN";
                break;
            case 2:
                names="FEB";
                break;
            case 3:
                names="MAR";
                break;
            case 4:
                names="APR";
                break;
            case 5:
                names="MAY";
                break;
            case 6:
                names="JUN";
                break;
            case 7:
                names="JULY";
                break;
            case 8:
                names="AUG";
                break;
            case 9:
                names="SEPT";
                break;
            case 10:
                names="OCT";
                break;
            case 11:
                names="NOV";
                break;
            case 12:
                names="DEC";
                break;






        }
        return names;
    }
}
