package com.citchennai.cse.moneymanager;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    Integer [] imageId;
    Cursor cs;
    Database db;
    TextView tw;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Context contex, String[] messagelist, Integer[] apt_images, Cursor cs,Database db,TextView tw) {
        this.tw=tw;
        // TODO Auto-generated constructor stub
        result=messagelist;
        context=contex;
        imageId=apt_images;
        this.cs=cs;
        this.db=db;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
        ImageView imgdelte;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.message_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        //holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.imgdelte=(ImageView) rowView.findViewById(R.id.delete);
        holder.imgdelte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deletemessage(imageId[position]+"");
                holder.tv.setVisibility(View.INVISIBLE);
                holder.imgdelte.setVisibility(View.INVISIBLE);

                Cursor c=db.GetTotal();
                while(c.moveToNext())
                    tw.setText("Rs. "+c.getString(0));

                ListView ls=(ListView)view.findViewById(R.id.messages);
//                holder.img.setVisibility(View.INVISIBLE);
               // Toast.makeText(context, "You Clicked "+imageId[position], Toast.LENGTH_LONG).show();
            }
        });
        holder.tv.setText(result[position]);
       // holder.img.setImageResource(imageId[position]);
        holder.imgdelte.setImageResource(R.drawable.ic_delete_black_48dp);
//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
//            }
//        });
        return rowView;
    }

}