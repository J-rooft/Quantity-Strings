package com.nocturnaldev.qsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (savedInstanceState != null) {
            return;
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment listFragment = new SampleListFragment();
        fm.beginTransaction().add(android.R.id.content, listFragment).commit();
    }

}
