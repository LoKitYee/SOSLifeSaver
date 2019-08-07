package com.example.sos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new Homefragment() ;
        loadFragemt(fragment);
        BottomNavigationView navView = findViewById(R.id.nav_view );
        BottomNavigationView topView = findViewById(R.id.nav_view_top) ;

        navView.setOnNavigationItemSelectedListener(this);
        topView.setOnNavigationItemSelectedListener(this);



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
    public void openContact()
    {  Intent intent = new Intent(this,contacts.class);
        startActivity(intent);
    }
    public void openSetting()
    {  Intent intent = new Intent(this,Setting.class);
        startActivity(intent);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch (menuItem.getItemId())
        {
            case R.id.navigation_home :
                fragment = new Homefragment() ;
                break;
            case R.id.navigation_rescue:
                fragment = new rescuefragment() ;
                break;
            case R.id.navigation_contacts:
               openContact();
                break;
            case R.id.navigation_setting:
                openSetting();
                break;


        }
        return loadFragemt(fragment);
    }


}
