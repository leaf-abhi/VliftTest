package com.example.toni.vlifttest.activity;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.SessionManager;
import com.example.toni.vlifttest.fragment.main.MenuFragment;
import com.example.toni.vlifttest.fragment.main.NewLeadsFragment;
import com.example.toni.vlifttest.fragment.main.OngoingFragment;
import com.example.toni.vlifttest.fragment.main.ProfileFragment;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view_main);
        frameLayout = findViewById(R.id.frame_layout_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.menu_item_new : {
                        fragment = NewLeadsFragment.newInstance();
                        break;
                    }

                    case R.id.menu_item_ongoing : {
                        fragment = OngoingFragment.newInstance();
                        break;
                    }

                    case R.id.menu_item_profile : {
                        fragment = ProfileFragment.newInstance();
                        break;
                    }

                    case R.id.menu_item_menu : {
                        fragment = MenuFragment.newInstance();
                        break;
                    }

                    default : {
                        return false;
                    }
                }
                ft.replace(frameLayout.getId(),fragment);
                ft.commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.menu_item_profile);
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(),ProfileFragment.newInstance())
                .commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!SessionManager.getInstance().isSessionAlive())
            this.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
