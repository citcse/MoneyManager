package com.citchennai.cse.moneymanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
EditText entryPass;
    Button signin;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        entryPass= (EditText) findViewById(R.id.entryPassword);
        signin= (Button) findViewById(R.id.SignIn);
        username=getIntent().getExtras().getString("username");
        password=getIntent().getExtras().getString("password");
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                  if(password.equals(entryPass.getText().toString().trim()))
                                  {
                                      Intent intent = new Intent(getApplicationContext(),NavigationDrawer.class);
                                      intent.putExtra("username_signin",username);
                                      startActivity(intent);
                                      finish();
                                  }

                else
                                      Toast.makeText(SignIn.this, "Check Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
