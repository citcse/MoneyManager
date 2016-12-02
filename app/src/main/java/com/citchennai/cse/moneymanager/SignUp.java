package com.citchennai.cse.moneymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
EditText editTextUser,editTextPassword;
    Button signup;
    Database database=new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextUser= (EditText) findViewById(R.id.editTextUser);
        editTextPassword= (EditText) findViewById(R.id.editTextpassword);
        signup= (Button) findViewById(R.id.SignUp);
        database=new Database(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUser!=null&&editTextPassword!=null) {
                    if(!(editTextUser.getText().equals("")&&editTextPassword.getText().equals(""))) {
                        database.InsertUser(editTextUser.getText().toString().trim(),editTextPassword.getText().toString());
                        Intent nav = new Intent(getApplicationContext(), NavigationDrawer.class);
                        nav.putExtra("username_signin",editTextUser.getText());
                        startActivity(nav);
                        finish();
                        Toast.makeText(SignUp.this, "Please dont forget the password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
