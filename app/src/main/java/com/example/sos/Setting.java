package com.example.sos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Setting extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        BottomNavigationView topView = findViewById(R.id.nav_view_top) ;
        topView.setOnNavigationItemSelectedListener(this);

        topView.getMenu() .getItem(2).setChecked(true);






    }


    private boolean loadFragemt(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager() .beginTransaction() .replace(R.id.frame_container,fragment).commit() ;
            return true;
        }
        return false;


    }
    public void openMainActivity()
    {  Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openContect()
    {  Intent intent = new Intent(this,contacts.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch (menuItem.getItemId())
        {
            case R.id.navigation_home :
                openMainActivity();
                break;
            case R.id.navigation_rescue:
                fragment = new rescuefragment() ;
                break;
            case R.id.navigation_contacts:
                openContect();
                break;

        }
        return loadFragemt(fragment);
    }
}
