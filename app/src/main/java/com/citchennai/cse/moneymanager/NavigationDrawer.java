package com.citchennai.cse.moneymanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View header=navigationView.getHeaderView(0);
        TextView name = (TextView) header.findViewById(R.id.displayname);
        try {

               // name.setText(getIntent().getExtras().get("signup").toString());


                name.setText(getIntent().getExtras().getString("username_signin"));

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment=new Messages();
        ft.replace(R.id.content_navigation_drawer, fragment);
        ft.commit();
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),DatabaseView.class));
//               // startActivity(new Intent(getApplicationContext(),Form.class));
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //Fragment fragmentss = new Messages();
        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.replace(R.id.content_navigation_drawer, fragmentss);
        //ft.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

      displaySelected(id);


        return true;
    }
    public void displaySelected(int itemid)
    {
        Fragment fragment=null;
    switch(itemid)
    {
        case R.id.nav_budget:
        fragment=new Budget();
            break;
        case R.id.nav_myexpenses:
            fragment=new MyExpenses();
            break;
        case R.id.nav_note:
            fragment=new Reminder();
            break;
        case R.id.nav_charts:
            fragment=new Charts();
            break;

        case R.id.messages:
            fragment=new Messages();

break;
    }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_navigation_drawer, fragment);
            ft.commit();
        }else{
            fragment=new Messages();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_navigation_drawer, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
