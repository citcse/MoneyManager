package com.citchennai.cse.moneymanager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView introtext;
    Database database;
    public String user_name,user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        introtext= (TextView) findViewById(R.id.text);
        database=new Database(this);
        try {
            Cursor result=database.GetUserData();
            while(result.moveToNext())
            {
                user_name=result.getString(0);
                user_password=result.getString(1);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(user_name==null)
                    startActivity(new Intent(getApplicationContext(),SignUp.class));
                else
                {
                    Intent sigin=new Intent(getApplicationContext(),SignIn.class);
                    sigin.putExtra("username",user_name);
                    sigin.putExtra("password",user_password);
                    startActivity(sigin);
                }

                finish();
            }
        }, secondsDelayed * 1000);


    }
}
