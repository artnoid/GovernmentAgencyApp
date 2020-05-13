package com.example.datainstansi.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;

import com.example.datainstansi.R;
import com.example.datainstansi.view.fragment.DistrictFragment;
import com.example.datainstansi.view.fragment.HomeFragment;
import com.example.datainstansi.view.fragment.OfficeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView btmNav;
    private Fragment selectedFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btmNav = findViewById(R.id.activitymain_bottomnav);
        btmNav.setOnNavigationItemSelectedListener(this);
        loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activitymain_container,selectedFragment)
                    .commit();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home:
                selectedFragment = new HomeFragment();
                break;

            case R.id.menu_district:
                selectedFragment = new DistrictFragment();
                break;

            case R.id.menu_office:
                selectedFragment = new OfficeFragment();
                break;
        }
        return loadFragment(selectedFragment);
    }
}
