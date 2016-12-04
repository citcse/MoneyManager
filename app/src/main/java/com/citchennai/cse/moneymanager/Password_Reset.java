package com.citchennai.cse.moneymanager;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password_Reset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password__reset);
        Button btn=(Button)findViewById(R.id.change_password_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText old_password=(EditText)findViewById(R.id.old_password);
                EditText new_password=(EditText)findViewById(R.id.new_password);
                EditText confirm_password=(EditText)findViewById(R.id.confirm_new_password);
                Database db=new Database(getApplication());
                Cursor old_data=db.GetUserData();
                String db_old_password="";
                String db_old_user="";
                while(old_data.moveToNext())
                {
                    db_old_user=old_data.getString(0);
                    db_old_password=old_data.getString(1);
                }
                if(db_old_password.equals(old_password.getText().toString()))
                {
                    if(new_password.getText().toString().equals(confirm_password.getText().toString()))
                    {
                        if(new_password.getText().toString().equals(""))
                            Toast.makeText(Password_Reset.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                        else {
                            db.updatepassword(db_old_user, new_password.getText().toString());
                            Toast.makeText(Password_Reset.this, "Succesfully Changed the password", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Password_Reset.this, "Please check conform password", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Password_Reset.this, "Please Enter Correct Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
