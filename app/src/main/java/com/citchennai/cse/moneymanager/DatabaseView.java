package com.citchennai.cse.moneymanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseView extends AppCompatActivity {
    Database database;
    StringBuffer buffer;
    TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view);
        database=new Database(this);
        data= (TextView) findViewById(R.id.database);
        Cursor res=database.GetUserData();
        buffer = new StringBuffer();
        while(res.moveToNext())
        {
            buffer.append("username: "+ res.getString(0)+"\n");
            buffer.append("password: "+res.getString(1)+"\n\n");
        }
        if(res.getCount()>0)
        {
            data.setText(buffer);
        }
        else
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
    }
}
