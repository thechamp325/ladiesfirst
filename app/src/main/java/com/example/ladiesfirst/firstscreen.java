package com.example.ladiesfirst;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class firstscreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    Button alarm;     //button which produces sound on click
    Button send;
    SmsManager smsManager;
    private static final String TAG = "Home";
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.firstscreen);
    alarm = findViewById(R.id.sound);
    send = findViewById(R.id.sendSMS);



    NavigationView navigationView;
    navigationView = findViewById(R.id.nav_view);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    drawer = findViewById(R.id.drawer_layout);
   //what happens on pressing three lines...is here
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open
         ,R.string.navigation_drawer_close);
//
  drawer.addDrawerListener(toggle);
    toggle.syncState();
   if(savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeScreen()).commit();
        navigationView.setCheckedItem(R.id.home);
       //and also the button wrt that item should be pressed in navbar
    }
    //to select which menu item should be shown by default


}
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch(menuItem.getGroupId()){

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        //if drawer is opened and we press back then navigation-bar should go back(minimize)
        //else go back to previous activity
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}
